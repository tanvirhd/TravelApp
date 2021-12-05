package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.databinding.ActivityCreateAccountBinding;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.utils.Tools;
import com.example.travelapplication.viewholder.ViewModelTravelApp;

public class ActivityCreateAccount extends AppCompatActivity {

    private static final String TAG = "ActivityCreateAccount";
    private ActivityCreateAccountBinding binding;
    private ViewModelTravelApp viewModelTravelApp;
    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        binding.btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.etPhoneNumber.getText().toString().length()!=11){
                    Toast.makeText(ActivityCreateAccount.this, "Invalid Phone Number!", Toast.LENGTH_SHORT).show();
                }else{
                    dialogLoading.show();
                    viewModelTravelApp.checkUserValidation(new ModelUser(binding.etPhoneNumber.getText().toString()))
                    .observe(ActivityCreateAccount.this, new Observer<ModelValidation>() {
                        @Override
                        public void onChanged(ModelValidation modelValidation) {
                            dialogLoading.dismiss();
                            if(modelValidation==null){
                                Toast.makeText(ActivityCreateAccount.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                            }else {
                                if(modelValidation.isNewUser()){
                                   Intent intent=new Intent(ActivityCreateAccount.this,ActivityVerifyOTP.class);
                                   intent.putExtra("phone-number",binding.etPhoneNumber.getText().toString());
                                   startActivity(intent);
                                }else {
                                    Toast.makeText(ActivityCreateAccount.this, "Already Registered", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });

                }
            }
        });
    }

    void init(){
        viewModelTravelApp =new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelTravelApp.class);
        dialogLoading= Tools.setupLoadingDialog(ActivityCreateAccount.this);
    }


}