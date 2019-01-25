package com.vacreall.healthopt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DiseasAdapter extends RecyclerView.Adapter<DiseasAdapter.ViewHolder> {

    ArrayList diseasNames,symptomsNo,category,specialist,description;
    Context baseContext;

    public DiseasAdapter(Context baseContext, ArrayList diseasNames, ArrayList symptomsNo, ArrayList category, ArrayList description) {
        this.baseContext = baseContext;
        this.diseasNames = diseasNames;
        this.symptomsNo = symptomsNo;
        this.category = category;
        this.description = description;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diseas_row, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.diseas_name.setText((CharSequence) diseasNames.get(i));
        viewHolder.symptomsNo.setText((CharSequence) symptomsNo.get(i));
        viewHolder.category.setText((CharSequence) category.get(i));
        viewHolder.description.setText((CharSequence) description.get(i));
        viewHolder.diseas_image.setImageResource(R.drawable.disease_ico);
    }

    @Override
    public int getItemCount() {
        return diseasNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView diseas_name;
        TextView symptomsNo;
        TextView category;
        TextView description;
        ImageView diseas_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            diseas_image = (ImageView) itemView.findViewById(R.id.diseas_image);
            diseas_name = (TextView) itemView.findViewById(R.id.diseas_name);
            symptomsNo = (TextView) itemView.findViewById(R.id.symptomsNo);
            category = (TextView) itemView.findViewById(R.id.category);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
