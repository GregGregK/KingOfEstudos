package com.example.kingofestudos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView card1 , card2 , card3 , card4 , card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        card1 = (CardView) findViewById(R.id.obj_card);
        card2 = (CardView) findViewById(R.id.sau_card);
        card3 = (CardView) findViewById(R.id.tar_card);
        card4 = (CardView) findViewById(R.id.cal_card);
        card5 = (CardView) findViewById(R.id.cro_card);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.obj_card :
                i = new Intent(this,ObjetivoActivity.class);
                startActivity(i);
                break;

            case R.id.sau_card :
                i = new Intent(this,SaudeActivity.class);
                startActivity(i);
                break;

            case R.id.tar_card :
                i = new Intent(this,TarefasActivity.class);
                startActivity(i);
                break;

            case R.id.cal_card :
                i = new Intent(this,CalendarioActivity.class);
                startActivity(i);
                break;

            case R.id.cro_card :
                i = new Intent(this,CronometroActivity.class);
                startActivity(i);
                break;



        }

    }
}