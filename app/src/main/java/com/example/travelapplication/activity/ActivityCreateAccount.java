package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityCreateAccountBinding;

public class ActivityCreateAccount extends AppCompatActivity {

    private static final String TAG = "ActivityCreateAccount";
    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityCreateAccount.this,ActivityVerifyOTP.class));
            }
        });
    }
}