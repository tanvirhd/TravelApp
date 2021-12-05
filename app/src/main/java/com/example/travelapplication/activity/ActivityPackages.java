package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.adapter.AdapterPackageList;
import com.example.travelapplication.callbacks.AdapterPackageListCallbacks;
import com.example.travelapplication.databinding.ActivityPackagesBinding;
import com.example.travelapplication.model.ModelTourPackage;
import com.example.travelapplication.utils.Tools;
import com.example.travelapplication.viewholder.ViewModelTravelApp;

import java.util.ArrayList;
import java.util.List;

public class ActivityPackages extends AppCompatActivity implements AdapterPackageListCallbacks {

    private static final String TAG = "ActivityPackages";

    private ActivityPackagesBinding binding;

    private  ViewModelTravelApp viewModelTravelApp;
    private  AdapterPackageList adapterPackageList;
    private  List<ModelTourPackage> tourPackageList;
    private Dialog dialogLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        binding=ActivityPackagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAvailablePackages();
    }

    void  init(){
        viewModelTravelApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelTravelApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityPackages.this);
        tourPackageList=new ArrayList<>();
        adapterPackageList=new AdapterPackageList(ActivityPackages.this,tourPackageList,ActivityPackages.this);
        binding.recycPackages.setAdapter(adapterPackageList);
        binding.recycPackages.setLayoutManager(new LinearLayoutManager(ActivityPackages.this));
    }

    void getAvailablePackages(){
        //Log.d(TAG, "getAvailablePackages: called");
        dialogLoading.show();
        viewModelTravelApp.getAllPublishedEvents().observe(ActivityPackages.this, new Observer<List<ModelTourPackage>>() {
            @Override
            public void onChanged(List<ModelTourPackage> modelTourPackages) {
                if(modelTourPackages!=null && !modelTourPackages.isEmpty()){
                    //Log.d(TAG, "onChanged: data found :"+modelTourPackages.get(0).getEvenName());
                    dialogLoading.dismiss();
                    tourPackageList.clear();
                    tourPackageList.addAll(modelTourPackages);
                    adapterPackageList.notifyDataSetChanged();
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityPackages.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onPackageClicked(int position) {
        Intent intent=new Intent(ActivityPackages.this,ActivityPackageDetails.class);
        intent.putExtra("parcel-data",tourPackageList.get(position));
        intent.putExtra("caller","packages");
        startActivity(intent);//finish();
    }
}