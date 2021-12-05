package com.example.travelapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.adapter.AdapterItinerancy;
import com.example.travelapplication.databinding.FragmentItinerancyBinding;
import com.example.travelapplication.model.ModelPackageSchedule;

import java.util.List;

public class FragmentItinerancy extends Fragment {

    private static final String TAG = "FragmentItinerancy";
    private FragmentItinerancyBinding binding;

    private List<ModelPackageSchedule> scheduleList;
    AdapterItinerancy adapterItinerancy;

    public FragmentItinerancy(List<ModelPackageSchedule> scheduleList) {
        this.scheduleList=scheduleList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapterItinerancy =new AdapterItinerancy(getActivity(),scheduleList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentItinerancyBinding.inflate(inflater,container,false);

        binding.recycItinerancy.setAdapter(adapterItinerancy);
        binding.recycItinerancy.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }
}