package com.example.travelapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.databinding.LayoutFoodCourseBinding;
import com.example.travelapplication.model.ModelPackageFoodCourse;

import java.util.List;

public class AdapterFoodCourseList extends  RecyclerView.Adapter<AdapterFoodCourseList.AdapterFoodCourseListViewHolder>{
    Context context;
    List<ModelPackageFoodCourse> foodCourses;

    public AdapterFoodCourseList(Context context, List<ModelPackageFoodCourse> foodCourses) {
        this.context = context;
        this.foodCourses = foodCourses;
    }

    @NonNull
    @Override
    public AdapterFoodCourseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutFoodCourseBinding layoutFoodCourseBinding=LayoutFoodCourseBinding.inflate(LayoutInflater.from(context),parent,false);
        return new AdapterFoodCourseListViewHolder(layoutFoodCourseBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFoodCourseListViewHolder holder, int position) {
        ModelPackageFoodCourse foodCourse=foodCourses.get(position);
        holder.layoutFoodCourseBinding.tvDayCount.setText("Day "+foodCourse.getDayCount());
        holder.layoutFoodCourseBinding.tvBreakFast.setText(foodCourse.getBreakfast());
        holder.layoutFoodCourseBinding.tvLunch.setText(foodCourse.getLunch());
        holder.layoutFoodCourseBinding.tvDinner.setText(foodCourse.getDinner());
    }

    @Override
    public int getItemCount() {
        return foodCourses.size();
    }


    class AdapterFoodCourseListViewHolder extends RecyclerView.ViewHolder{
        LayoutFoodCourseBinding layoutFoodCourseBinding;
        public AdapterFoodCourseListViewHolder(LayoutFoodCourseBinding layoutFoodCourseBinding) {
            super(layoutFoodCourseBinding.getRoot());
            this.layoutFoodCourseBinding=layoutFoodCourseBinding;
        }
    }
}
