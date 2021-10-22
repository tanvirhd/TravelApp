package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.ActivityCompleteAccountBinding;
import com.example.travelapplication.databinding.ActivityCreateAccountBinding;

public class ActivityCompleteAccount extends AppCompatActivity {

    private static final String TAG = "ActivityCompleteAccount";
    private ActivityCompleteAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCompleteAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCompleteRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityCompleteAccount.this,ActivityHome.class));
            }
        });
    }
}