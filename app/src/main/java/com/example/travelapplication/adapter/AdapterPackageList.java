package com.example.travelapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.callbacks.AdapterPackageListCallbacks;
import com.example.travelapplication.databinding.LayoutPackageBinding;
import com.example.travelapplication.model.ModelTourPackage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPackageList extends RecyclerView.Adapter<AdapterPackageList.ViewHolderAdapterPackageList>{
    private static final String TAG = "AdapterPackageList";
    Context context;
    List<ModelTourPackage> tourPackageList;
    AdapterPackageListCallbacks callbacks;

    public AdapterPackageList(Context context, List<ModelTourPackage> tourPackageList, AdapterPackageListCallbacks callbacks) {
        this.context = context;
        this.tourPackageList = tourPackageList;
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPackageList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPackageBinding layoutPackageBinding=LayoutPackageBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolderAdapterPackageList(layoutPackageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPackageList holder, int position) {
        ModelTourPackage tourPackage=tourPackageList.get(position);

        Picasso.with(context).load(tourPackage.getEventPhotoUrl()).into(holder.layoutPackageBinding.ivPackageImage);
        holder.layoutPackageBinding.tvPackageName.setText(tourPackage.getEvenName());
        holder.layoutPackageBinding.tvDays.setText(tourPackage.getNumOfDays()+" Days");
        holder.layoutPackageBinding.tvNights.setText(tourPackage.getNumberOfNight()+" Nights");
        holder.layoutPackageBinding.tvNumberOfPlaces.setText(tourPackage.getNumberOfPlaces()+" Places");

        holder.layoutPackageBinding.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbacks.onPackageClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tourPackageList.size();
    }

    class ViewHolderAdapterPackageList extends RecyclerView.ViewHolder{
        private LayoutPackageBinding layoutPackageBinding;
        public ViewHolderAdapterPackageList(LayoutPackageBinding layoutPackageBinding) {
            super(layoutPackageBinding.getRoot());
            this.layoutPackageBinding=layoutPackageBinding;
        }
    }
}
