package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.FragmentFoodCourseBinding;
import com.example.travelapplication.databinding.FragmentNeedToCarryBinding;
import com.example.travelapplication.databinding.FragmentPackageDetailsBinding;


public class FragmentNeedToCarry extends Fragment {

    private static final String TAG = "FragmentNeedToCarry";
    private FragmentNeedToCarryBinding binding;
    private String needToCarry="";

    public FragmentNeedToCarry(String data) {
        this.needToCarry=data;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNeedToCarryBinding.inflate(inflater,container,false);
        binding.tvNeedToCarry.setText(needToCarry);
        return binding.getRoot();
    }
}