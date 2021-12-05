package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.databinding.FragmentIncludesBinding;


public class FragmentIncludes extends Fragment {
    private static final String TAG = "FragmentIncludes";
    private FragmentIncludesBinding binding;
    private String tourIncluding="";
    public FragmentIncludes(String including) {
        this.tourIncluding=including;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIncludesBinding.inflate(inflater,container,false);
        binding.tvIncludes.setText(tourIncluding);
        return binding.getRoot();
    }
}