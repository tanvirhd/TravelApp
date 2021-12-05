package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityCompleteAccountBinding;
import com.example.travelapplication.databinding.ActivityCreateAccountBinding;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.response.ModelResponseRegistration;
import com.example.travelapplication.utils.GlobalKey;
import com.example.travelapplication.utils.Tools;
import com.example.travelapplication.viewholder.ViewModelTravelApp;

public class ActivityCompleteAccount extends AppCompatActivity {

    private static final String TAG = "ActivityCompleteAccount";
    private ActivityCompleteAccountBinding binding;
    private ViewModelTravelApp viewModelTravelApp;
    private Dialog dialogLoading;
    private String phoneNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompleteAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.btnCompleteRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.etName.getText().toString().isEmpty() || binding.etPass.getText().toString().isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(ActivityCompleteAccount.this, "Empty Filed Found", Toast.LENGTH_SHORT).show();
                }else {
                    dialogLoading.show();
                    viewModelTravelApp.regUser(new ModelUser(
                            binding.etName.getText().toString(),
                            phoneNumber,
                            binding.etPass.getText().toString(),
                            "https://google.com"
                    )).observe(ActivityCompleteAccount.this, new Observer<ModelResponseRegistration>() {
                        @Override
                        public void onChanged(ModelResponseRegistration modelResponseRegistration) {
                            dialogLoading.dismiss();
                            if(modelResponseRegistration!=null && modelResponseRegistration.getResponse()==1){
                                Tools.savePrefBoolean(GlobalKey.IS_LOGGED_IN,true);
                                startActivity(new Intent(ActivityCompleteAccount.this,ActivityHome.class));
                            }else{
                                Toast.makeText(ActivityCompleteAccount.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }

    void  init(){
        viewModelTravelApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelTravelApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityCompleteAccount.this);

        phoneNumber=getIntent().getStringExtra("phone-number");
    }
}