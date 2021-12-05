package com.example.travelapplication.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.travelapplication.fragment.FragmentCosting;
import com.example.travelapplication.fragment.FragmentFoodCourse;
import com.example.travelapplication.fragment.FragmentIncludes;
import com.example.travelapplication.fragment.FragmentItinerancy;
import com.example.travelapplication.fragment.FragmentNeedToCarry;
import com.example.travelapplication.fragment.FragmentPackageDetails;
import com.example.travelapplication.model.ModelTourPackage;

public class AdapterViewPager  extends FragmentStateAdapter {
    private static final String TAG = "AdapterViewPager";

    private ModelTourPackage tourPackage;
    FragmentActivity fragmentActivity;
    public AdapterViewPager(@NonNull FragmentActivity fragmentActivity, ModelTourPackage tourPackage) {
        super(fragmentActivity);
        this.fragmentActivity=fragmentActivity;
        this.tourPackage=tourPackage;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                Log.d(TAG, "createFragment: "+tourPackage.getEventSchedule().size());
                return new FragmentItinerancy(tourPackage.getEventSchedule());
            case 2:
                return new FragmentIncludes(tourPackage.getEventIncludings());
            case 3:
                return new FragmentFoodCourse(tourPackage.getEventFoodCourse());
            case 4:
                return new FragmentNeedToCarry(tourPackage.getNeedToCarry());
            case 5:
                return new FragmentCosting(tourPackage.getEventCost().get(0));
            default:
                return new FragmentPackageDetails(tourPackage.getEventDetails());
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}