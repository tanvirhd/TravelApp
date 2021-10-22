package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityHomeBinding;

public class ActivityHome extends AppCompatActivity {

    private static final String TAG = "ActivityHome";
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}