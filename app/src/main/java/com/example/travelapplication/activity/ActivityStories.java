package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityStoriesBinding;

public class ActivityStories extends AppCompatActivity {
    private static final String TAG = "ActivityStories";
    private ActivityStoriesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    void init(){
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Client Login");
    }
}