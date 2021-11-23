package com.example.kingofestudos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

{
    public final TextView diaDoMes;
    private final AdaptadorCalendario.OnItemListener onItemListener;
    public CalendarioViewHolder(@NonNull View itemView, AdaptadorCalendario.OnItemListener onItemListener) {
        super(itemView);
        diaDoMes = itemView.findViewById(R.id.cellDiaText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getAdapterPosition(), (String) diaDoMes.getText());
    }
}
