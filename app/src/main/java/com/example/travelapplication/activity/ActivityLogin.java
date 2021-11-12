package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityLoginBinding;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.response.ModelResponseLogin;
import com.example.travelapplication.viewholder.ViewModelTravelApp;

public class ActivityLogin extends AppCompatActivity  {
    private static final String TAG = "ActivityLogin";
    private ActivityLoginBinding binding;
    private ViewModelTravelApp viewModelTravelApp;
    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this,ActivityCreateAccount.class));
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLoading.show();
                ModelUser userLoginCredential=new ModelUser(binding.etPhoneNumber.getText().toString(),binding.etPassword.getText().toString());
                viewModelTravelApp.loginUser(userLoginCredential).observe(ActivityLogin.this, new Observer<ModelResponseLogin>() {
                    @Override
                    public void onChanged(ModelResponseLogin modelResponseLogin) {
                        if(modelResponseLogin != null && modelResponseLogin.getResponseCode() == 200){
                            dialogLoading.dismiss();
                            startActivity(new Intent(ActivityLogin.this,ActivityHome.class));
                        }else{
                            dialogLoading.dismiss();
                            Toast.makeText(ActivityLogin.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    void init(){
        viewModelTravelApp=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelTravelApp.class);
        dialogLoading=createLoadingDialog();
    }


    Dialog createLoadingDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }

}