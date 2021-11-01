package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.travelapplication.R;
import com.example.travelapplication.adapter.AdapterHomeOption;
import com.example.travelapplication.callbacks.AdapterHomeOptionCallbacks;
import com.example.travelapplication.databinding.ActivityHomeBinding;
import com.example.travelapplication.model.ModelHomeOption;

import java.util.Arrays;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements AdapterHomeOptionCallbacks {

    private static final String TAG = "ActivityHome";
    private ActivityHomeBinding binding;
    private AdapterHomeOption adapterHomeOption;

    private final List<ModelHomeOption> homeOptions= Arrays.asList(
            new ModelHomeOption("Stories","Explore Beautiful Sights",R.drawable.icon_stories),
            new ModelHomeOption("Upcoming Events","2 Events Upcoming",R.drawable.icon_upcoming_events),
            new ModelHomeOption("Packages","12 Packages",R.drawable.icon_packages),
            new ModelHomeOption("Gallery","49 Photos",R.drawable.icon_gallary)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    void init(){
        adapterHomeOption=new AdapterHomeOption(homeOptions,ActivityHome.this,ActivityHome.this);
        binding.recycHomeOption.setAdapter(adapterHomeOption);
        binding.recycHomeOption.setLayoutManager(new GridLayoutManager(ActivityHome.this,2));
    }


    @Override
    public void onHomeOptionSelected(int position) {
        Toast.makeText(ActivityHome.this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}