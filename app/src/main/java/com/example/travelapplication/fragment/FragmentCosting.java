package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.R;
import com.example.travelapplication.databinding.FragmentCostingBinding;
import com.example.travelapplication.databinding.FragmentNeedToCarryBinding;
import com.example.travelapplication.databinding.FragmentPackageDetailsBinding;
import com.example.travelapplication.model.ModelPackageCost;

public class FragmentCosting extends Fragment {
    private static final String TAG = "FragmentCosting";
    private FragmentCostingBinding binding;

    private ModelPackageCost packageCost;

    public FragmentCosting(ModelPackageCost packageCost) {
        this.packageCost=packageCost;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCostingBinding.inflate(inflater,container,false);

        binding.tvCostPerAdult.setText(packageCost.getCostPerAdult()+" Taka/Person(Adult)");
        binding.tvCostPerChild.setText(packageCost.getCostPerChild()+" Taka/Child(aged under 13)");

        binding.tvCostIncludes.setText(packageCost.getIncludings());
        return binding.getRoot();
    }
}