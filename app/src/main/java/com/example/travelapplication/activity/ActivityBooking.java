package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.travelapplication.databinding.ActivityBookingBinding;
import com.example.travelapplication.model.ModelTourPackage;

public class ActivityBooking extends AppCompatActivity {
    private static final String TAG = "ActivityBooking";
    private ActivityBookingBinding binding;
    private ModelTourPackage tourPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    void  init(){
        tourPackage=getIntent().getParcelableExtra("data");

    }
}