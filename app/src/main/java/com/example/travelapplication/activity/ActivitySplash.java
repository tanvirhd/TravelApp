package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivitySplashBinding;
import com.example.travelapplication.utils.GlobalKey;
import com.example.travelapplication.utils.Tools;

public class ActivitySplash extends AppCompatActivity {

    private static final String TAG = "ActivitySplash";
    private ActivitySplashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);*/

        binding.btnGetStarted.setVisibility(View.INVISIBLE);
        if(Tools.getPrefBoolean(GlobalKey.IS_LOGGED_IN,false)){
            startActivity(new Intent(ActivitySplash.this, ActivityHome.class));
            finish();
        }else {
            binding.btnGetStarted.setVisibility(View.VISIBLE);
        }

        binding.btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitySplash.this,ActivityLogin.class));finish();
            }
        });
    }
}