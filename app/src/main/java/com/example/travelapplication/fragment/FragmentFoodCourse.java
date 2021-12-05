package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.R;
import com.example.travelapplication.adapter.AdapterFoodCourseList;
import com.example.travelapplication.databinding.FragmentFoodCourseBinding;
import com.example.travelapplication.databinding.FragmentIncludesBinding;
import com.example.travelapplication.databinding.FragmentPackageDetailsBinding;
import com.example.travelapplication.model.ModelPackageFoodCourse;

import java.util.List;


public class FragmentFoodCourse extends Fragment {
    private static final String TAG = "FragmentFoodCourse";
    private FragmentFoodCourseBinding binding;
    private AdapterFoodCourseList adapterFoodCourseList;


    private List<ModelPackageFoodCourse> foodCourseList;

    public FragmentFoodCourse(List<ModelPackageFoodCourse> foodCourseList) {
        this.foodCourseList=foodCourseList;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapterFoodCourseList=new AdapterFoodCourseList(getActivity(),foodCourseList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFoodCourseBinding.inflate(inflater,container,false);

        binding.recycFoodCource.setAdapter(adapterFoodCourseList);
        binding.recycFoodCource.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }
}