package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivitySplashBinding;

public class ActivitySplash extends AppCompatActivity {

    private static final String TAG = "ActivitySplash";
    private ActivitySplashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitySplash.this,ActivityCreateAccount.class));
            }
        });
    }
}