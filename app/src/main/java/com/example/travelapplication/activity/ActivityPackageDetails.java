package com.example.travelapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapplication.adapter.AdapterViewPager;
import com.example.travelapplication.databinding.ActivityPackageDetailsBinding;
import com.example.travelapplication.model.ModelTourPackage;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

public class ActivityPackageDetails extends AppCompatActivity {
    private static final String TAG = "ActivityPackageDetails";
    private ActivityPackageDetailsBinding binding;

    private ModelTourPackage tourPackage;
    private AdapterViewPager adapterViewPager;
    private boolean showRemainingDate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPackageDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        binding.ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPackageDetails.this,ActivityBooking.class);
                intent.putExtra("data",tourPackage);
            }
        });
    }

    void init(){
        tourPackage=getIntent().getParcelableExtra("parcel-data");
        String caller=getIntent().getStringExtra("caller");

        if(caller!=null){
            if(caller.equals("packages"))
                showRemainingDate=false;
            else
                showRemainingDate=true;
        }

        if(tourPackage !=null){
            updateUI(tourPackage);
            adapterViewPager=new AdapterViewPager(ActivityPackageDetails.this,tourPackage);
            binding.viewpager.setAdapter(adapterViewPager);
            TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(
                    binding.tabLayout,  binding.viewpager,
                    new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            switch (position){
                                case 0:
                                    tab.setText("Package Details");
                                    break;
                                case 1:
                                    tab.setText("Itinerancy");
                                    break;
                                case 2:
                                    tab.setText("Includes");
                                    break;
                                case 3:
                                    tab.setText("Food Menu");
                                    break;
                                case 4:
                                    tab.setText("Need To Carry");
                                    break;
                                case 5:
                                    tab.setText("Total Costing");
                                    break;
                            }
                        }
                    });
            tabLayoutMediator.attach();
            wrapTabIndicatorToTitle(binding.tabLayout,50,50);
        }


    }

    void updateUI(ModelTourPackage modelTourPackage){
        binding.tvPackageName.setText(modelTourPackage.getEvenName());
        if(showRemainingDate)
            binding.tvRemainingDays.setVisibility(View.VISIBLE);
        else
            binding.tvRemainingDays.setVisibility(View.INVISIBLE);

        Picasso.with(ActivityPackageDetails.this).load(modelTourPackage.getEventPhotoUrl()).into(binding.ivPackageImage);
    }

    public void wrapTabIndicatorToTitle(TabLayout tabLayout, int externalMargin, int internalMargin) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            int childCount = ((ViewGroup) tabStrip).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View tabView = tabStripGroup.getChildAt(i);
                //set minimum width to 0 for instead for small texts, indicator is not wrapped as expected
                tabView.setMinimumWidth(0);
                // set padding to 0 for wrapping indicator as title
                tabView.setPadding(0, tabView.getPaddingTop(), 0, tabView.getPaddingBottom());
                // setting custom margin between tabs
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
                    if (i == 0) {
                        // left
                        settingMargin(layoutParams, externalMargin, internalMargin);
                    } else if (i == childCount - 1) {
                        // right
                        settingMargin(layoutParams, internalMargin, externalMargin);
                    } else {
                        // internal
                        settingMargin(layoutParams, internalMargin, internalMargin);
                    }
                }
            }
            tabLayout.requestLayout();
        }
    }

    private void settingMargin(ViewGroup.MarginLayoutParams layoutParams, int start, int end) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.setMarginStart(start);
            layoutParams.setMarginEnd(end);
        } else {
            layoutParams.leftMargin = start;
            layoutParams.rightMargin = end;
        }
    }

}