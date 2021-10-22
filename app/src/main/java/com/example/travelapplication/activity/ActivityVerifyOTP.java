package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityVerifyOtpBinding;

public class ActivityVerifyOTP extends AppCompatActivity {

    private static final String TAG = "ActivityVerifyOTP";
    private ActivityVerifyOtpBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVerifyOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnVerifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityVerifyOTP.this,ActivityCompleteAccount.class));
            }
        });
    }
}