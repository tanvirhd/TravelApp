package com.example.travelapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.databinding.LayoutItinerancyBinding;
import com.example.travelapplication.model.ModelPackageSchedule;

import java.util.List;

public class AdapterItinerancy extends RecyclerView.Adapter<AdapterItinerancy.AdapterIncludesViewHolder>{
    private static final String TAG = "AdapterIncludes";
    Context context;
    List<ModelPackageSchedule> scheduleList;

    public AdapterItinerancy(Context context, List<ModelPackageSchedule> scheduleList) {
        Log.d(TAG, "AdapterIncludes: celled with file sise:"+scheduleList.size());
        this.context = context;
        this.scheduleList = scheduleList;
    }


    @NonNull
    @Override
    public AdapterIncludesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItinerancyBinding layoutItinerancyBinding=LayoutItinerancyBinding.inflate(LayoutInflater.from(context),parent,false);
        return new AdapterIncludesViewHolder(layoutItinerancyBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIncludesViewHolder holder, int position) {
        ModelPackageSchedule schedule=scheduleList.get(position);
        holder.layoutItinerancyBinding.tvDay.setText("Day "+schedule.getDayCount()+" :");
        holder.layoutItinerancyBinding.tvSchedule.setText(schedule.getScheculeDetails());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    class AdapterIncludesViewHolder extends RecyclerView.ViewHolder{
        LayoutItinerancyBinding layoutItinerancyBinding;
        public AdapterIncludesViewHolder(@NonNull LayoutItinerancyBinding layoutItinerancyBinding) {
            super(layoutItinerancyBinding.getRoot());
            this.layoutItinerancyBinding=layoutItinerancyBinding;
        }
    }

}
