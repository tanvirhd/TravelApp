package com.example.travelapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.databinding.LayoutPhotoBinding;
import com.example.travelapplication.model.ModelImage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPhotoList extends RecyclerView.Adapter<AdapterPhotoList.AdapterPhotoListViewHolder>{

    Context context;
    List<ModelImage> images;

    public AdapterPhotoList(Context context, List<ModelImage> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public AdapterPhotoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPhotoBinding layoutPhotoBinding=LayoutPhotoBinding.inflate(LayoutInflater.from(context),parent,false);
        return  new AdapterPhotoListViewHolder(layoutPhotoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhotoListViewHolder holder, int position) {
        ModelImage image=images.get(position);
        Picasso.with(context).load(image.getPhotoUrl()).into(holder.layoutPhotoBinding.ivPhoto);
        holder.layoutPhotoBinding.tvEventName.setText(image.getEventName());
        holder.layoutPhotoBinding.tvEventDate.setText(image.getDate());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class  AdapterPhotoListViewHolder extends RecyclerView.ViewHolder{
        LayoutPhotoBinding layoutPhotoBinding;
        public AdapterPhotoListViewHolder(LayoutPhotoBinding layoutPhotoBinding) {
            super(layoutPhotoBinding.getRoot());
            this.layoutPhotoBinding=layoutPhotoBinding;
        }
    }
}
