package com.example.kingofestudos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorCalendario extends RecyclerView.Adapter<CalendarioViewHolder>
{
    private final ArrayList<String> diasDoMes;
    private final OnItemListener onItemListener;

    public AdaptadorCalendario(ArrayList<String> diasDoMes, OnItemListener onItemListener) {
        this.diasDoMes = diasDoMes;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendario_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height= (int) (parent.getHeight() * 0.166666666);
        return new CalendarioViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarioViewHolder holder, int position)
    {
        holder.diaDoMes.setText(diasDoMes.get(position));
    }

    @Override
    public int getItemCount()
    {
        return diasDoMes.size();
    }

    public interface  OnItemListener{
        void onItemClick(int position, String diaText);
    }
}
