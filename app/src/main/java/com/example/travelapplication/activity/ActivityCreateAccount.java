package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityCreateAccountBinding;
import com.example.travelapplication.model.ModelUser;
import com.example.travelapplication.model.ModelValidation;
import com.example.travelapplication.viewholder.ViewModelCheckUser;

public class ActivityCreateAccount extends AppCompatActivity {

    private static final String TAG = "ActivityCreateAccount";
    private ActivityCreateAccountBinding binding;
    private ViewModelCheckUser viewModelCheckUser;

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
                    viewModelCheckUser.checkUserValidation(new ModelUser(binding.etPhoneNumber.getText().toString()))
                    .observe(ActivityCreateAccount.this, new Observer<ModelValidation>() {
                        @Override
                        public void onChanged(ModelValidation modelValidation) {
                            if(modelValidation==null){
                                Toast.makeText(ActivityCreateAccount.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                            }else {
                                if(modelValidation.isNewUser()){
                                   sentOTP();
                                   /*Intent intent=new Intent(ActivityCreateAccount.this,ActivityVerifyOTP.class);
                                   intent.putExtra("phone-number",binding.etPhoneNumber.getText().toString());
                                   startActivity(intent);*/
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
        viewModelCheckUser=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelCheckUser.class);
    }

    void sentOTP(){
        Toast.makeText(this, "New User", Toast.LENGTH_SHORT).show();
    }
}