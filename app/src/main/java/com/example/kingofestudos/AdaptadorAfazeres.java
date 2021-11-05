package com.example.kingofestudos;

import android.content.Context;
import android.content.Intent;
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
        myViewHolder.tituloafazer.setText(meusAfazeres.get(i).getTituloafazer());
        myViewHolder.descafazer.setText(meusAfazeres.get(i).getDescafazer());
        myViewHolder.dataafazer.setText(meusAfazeres.get(i).getDatafazer());


        final String getTituloAfazer = meusAfazeres.get(i).getTituloafazer();
        final String getDescAfazer = meusAfazeres.get(i).getDescafazer();
        final String getDataAfazer = meusAfazeres.get(i).getDatafazer();
        final String getKeyDoes = meusAfazeres.get(i).getKeydoes();
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context,EditarTaskDesk.class);
                aa.putExtra("tituloafazer", getTituloAfazer);
                aa.putExtra("descafazer", getDescAfazer);
                aa.putExtra("dataafazer", getDataAfazer);
                aa.putExtra("keydoes", getKeyDoes );
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meusAfazeres.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView tituloafazer, descafazer, dataafazer, keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloafazer = (TextView) itemView.findViewById(R.id.tituloafazer);
            descafazer = (TextView) itemView.findViewById(R.id.descafazer);
            dataafazer = (TextView) itemView.findViewById(R.id.dataafazer);

        }
    }
} 
