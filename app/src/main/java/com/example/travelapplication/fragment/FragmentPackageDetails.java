package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.FragmentPackageDetailsBinding;


public class FragmentPackageDetails extends Fragment {

    private static final String TAG = "FragmentPackageDetails";
    private FragmentPackageDetailsBinding binding;

    String packageDetails="";

    public FragmentPackageDetails(String packageDetails) {
        this.packageDetails=packageDetails;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPackageDetailsBinding.inflate(inflater,container,false);
        binding.tvPackageDetails.setText(packageDetails);
        return binding.getRoot();
    }
}