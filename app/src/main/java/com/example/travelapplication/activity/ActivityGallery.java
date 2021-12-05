package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.adapter.AdapterPhotoList;
import com.example.travelapplication.databinding.ActivityGalleryBinding;
import com.example.travelapplication.model.ModelImage;
import com.example.travelapplication.utils.Tools;
import com.example.travelapplication.viewholder.ViewModelTravelApp;

import java.util.ArrayList;
import java.util.List;

public class ActivityGallery extends AppCompatActivity {

    private static final String TAG = "ActivityGallery";
    private ActivityGalleryBinding binding;

    private ViewModelTravelApp viewModelTravelApp;
    private AdapterPhotoList adapterPhotoList;
    private List<ModelImage>  allImages;
    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGalleryBinding.inflate(getLayoutInflater());
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
        getAllImagesFromServer();
    }

    void init(){
        dialogLoading= Tools.setupLoadingDialog(ActivityGallery.this);
        viewModelTravelApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelTravelApp.class);
        allImages=new ArrayList<>();
        adapterPhotoList=new AdapterPhotoList(ActivityGallery.this,allImages);
        binding.recycPhoto.setAdapter(adapterPhotoList);
        binding.recycPhoto.setLayoutManager(new GridLayoutManager(ActivityGallery.this,2));
    }

    void getAllImagesFromServer(){
        dialogLoading.show();
        viewModelTravelApp.getAllImages().observe(ActivityGallery.this, new Observer<List<ModelImage>>() {
            @Override
            public void onChanged(List<ModelImage> modelImages) {
                if(modelImages!=null && !modelImages.isEmpty()){
                    dialogLoading.dismiss();
                    allImages.clear();
                    allImages.addAll(modelImages);
                    adapterPhotoList.notifyDataSetChanged();
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityGallery.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}