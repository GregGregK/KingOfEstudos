package com.example.kingofestudos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAfazeres extends RecyclerView.Adapter<AdaptadorAfazeres.MyViewHolder> {

    Context context;
    ArrayList<MeusAfazeres> meusAfazeres;

    public AdaptadorAfazeres(Context c, ArrayList<MeusAfazeres> p) {
        context = c;
        meusAfazeres = p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fazer, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(meusAfazeres.get(i).getTitledoes());
        myViewHolder.descdoes.setText(meusAfazeres.get(i).getDescdoes());
        myViewHolder.datedoes.setText(meusAfazeres.get(i).getDatedoes());
    }

    @Override
    public int getItemCount() {
        return meusAfazeres.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView titledoes, descdoes, datedoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);

        }
    }
} 
