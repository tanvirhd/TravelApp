package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelapplication.R;
import com.example.travelapplication.adapter.AdapterPackageList;
import com.example.travelapplication.callbacks.AdapterPackageListCallbacks;
import com.example.travelapplication.databinding.ActivityUpcomingEventsBinding;
import com.example.travelapplication.model.ModelPackageCost;
import com.example.travelapplication.model.ModelPackageFoodCourse;
import com.example.travelapplication.model.ModelPackageSchedule;
import com.example.travelapplication.model.ModelTourEvents;
import com.example.travelapplication.model.ModelTourPackage;

import java.util.ArrayList;
import java.util.List;

public class ActivityUpcomingEvents extends AppCompatActivity implements AdapterPackageListCallbacks {

    private static final String TAG = "ActivityUpcomingEvents";
    private ActivityUpcomingEventsBinding binding;

    private List<ModelTourPackage> tourEvents;
    private  AdapterPackageList adapterPackageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpcomingEventsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        dummyData();

        binding.ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }

    void init(){
        tourEvents=new ArrayList<>();
        adapterPackageList=new AdapterPackageList(ActivityUpcomingEvents.this,tourEvents,ActivityUpcomingEvents.this);
        binding.recycPackages.setAdapter(adapterPackageList);
        binding.recycPackages.setLayoutManager(new LinearLayoutManager(ActivityUpcomingEvents.this));
    }

    void dummyData(){

        ModelPackageSchedule schedule1=new ModelPackageSchedule(
                "schedule01",
                "event01",
                "0",
                "Details of First Day Schedule"
        );
        ModelPackageSchedule schedule2=new ModelPackageSchedule(
                "schedule02",
                "event01",
                "1",
                "Details of Second Day Schedule"
        );
        ModelPackageSchedule schedule3=new ModelPackageSchedule(
                "schedule03",
                "event01",
                "-1",
                "Details of Last Day Schedule"
        );


        ModelPackageFoodCourse foodCourse1=new ModelPackageFoodCourse(
                "food1",
                "event01",
                "1",
                "Porota, Dim, Dal-Vaji",
                "Rice, Chicken, Dal",
                "Morog Polao"
        );

        ModelPackageFoodCourse foodCourse2=new ModelPackageFoodCourse(
                "food2",
                "event01",
                "2",
                "Porota1, Dim1, Dal-Vaji1",
                "Rice2, Chicken2, Dal2",
                "Bamboo Chicken with rice"
        );

        ModelPackageCost cost=new ModelPackageCost(
            "cost1",
            "event01",
            "5000",
            "3000",
            "Accommodation, Food, local transport cost, photography"
        );

        List<ModelPackageCost> modelPackageCosts=new ArrayList<>();
        modelPackageCosts.add(cost);

        List<ModelPackageFoodCourse> foodCourses=new ArrayList<>();
        foodCourses.add(foodCourse1);foodCourses.add(foodCourse2);

        List<ModelPackageSchedule> schedules=new ArrayList<>();
        schedules.add(schedule1);schedules.add(schedule2);schedules.add(schedule3);


        tourEvents.add(new ModelTourPackage(
               "event01",
               "Khagrashori Tour",
               "2",
               "1",
                "3",
                "Khagrashori is a beautiful pace for tour. tour dummy details",
                "Personal belongings, Powerbank, charger",
                "Food\nAccommodation",
                "https://travellapp.duarbd.com/event001.png",
                "1",
                schedules,
                foodCourses,
                modelPackageCosts
        ));

        adapterPackageList.notifyDataSetChanged();
    }


    @Override
    public void onPackageClicked(int position) {
        Intent intent=new Intent(ActivityUpcomingEvents.this,ActivityPackageDetails.class);
        intent.putExtra("parcel-data",tourEvents.get(position));
        intent.putExtra("caller","upcoming-events");
        startActivity(intent);//finish();
    }
}