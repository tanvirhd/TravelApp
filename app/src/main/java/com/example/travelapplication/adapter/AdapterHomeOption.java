package com.example.travelapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.callbacks.AdapterHomeOptionCallbacks;
import com.example.travelapplication.databinding.LayoutHomeOptionBinding;
import com.example.travelapplication.model.ModelHomeOption;

import java.util.List;

public class AdapterHomeOption extends RecyclerView.Adapter<AdapterHomeOption.AdapterHomeOptionViewHolder>{

    List<ModelHomeOption> homeOptionList;
    Context context;
    AdapterHomeOptionCallbacks callbacks;

    public AdapterHomeOption(List<ModelHomeOption> homeOptionList, Context context, AdapterHomeOptionCallbacks callbacks) {
        this.homeOptionList = homeOptionList;
        this.context = context;
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public AdapterHomeOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutHomeOptionBinding  layoutHomeOptionBinding=LayoutHomeOptionBinding.inflate(LayoutInflater.from(context),parent,false);
        return new AdapterHomeOptionViewHolder(layoutHomeOptionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHomeOptionViewHolder holder, int position) {
        ModelHomeOption option=homeOptionList.get(position);
        holder.layoutHomeOptionBinding.tvOptionTitle.setText(option.getOptionTitle());
        holder.layoutHomeOptionBinding.tvOptionShortDes.setText(option.getOptionShortDetails());
        holder.layoutHomeOptionBinding.ivOptionImage.setImageResource(option.getOptionImage());

        holder.layoutHomeOptionBinding.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onHomeOptionSelected(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeOptionList.size();
    }

    class AdapterHomeOptionViewHolder extends RecyclerView.ViewHolder{
        private LayoutHomeOptionBinding layoutHomeOptionBinding;
        public AdapterHomeOptionViewHolder(LayoutHomeOptionBinding layoutHomeOptionBinding) {
            super(layoutHomeOptionBinding.getRoot());
            this.layoutHomeOptionBinding=layoutHomeOptionBinding;
        }
    }
}
