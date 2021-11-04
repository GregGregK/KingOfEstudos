package com.example.kingofestudos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ObjetivoActivity extends AppCompatActivity {
    TextView tituloPagina, subtituloPagina, fimdaPagina;
    Button btnAddNovo;

    DatabaseReference reference;
    RecyclerView seusafazeres;
    ArrayList<MeusAfazeres> list;
    AdaptadorAfazeres adaptadorAfazeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        tituloPagina = findViewById(R.id.tituloPagina);
        subtituloPagina = findViewById(R.id.subtituloPagina);
        fimdaPagina = findViewById(R.id.fimdaPagina);

        btnAddNovo = findViewById(R.id.btnAddNovo);
        btnAddNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ObjetivoActivity.this,NovoAfazerActivity.class);
                startActivity(a);
            }
        });


        //data
        seusafazeres = findViewById(R.id.seusafazeres);
        seusafazeres.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MeusAfazeres>();

        //Pegar DATA do firebase
        reference = FirebaseDatabase.getInstance().getReference().child("KingOfEstudos");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // codigo para resgatar DATA e realocar o layout
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MeusAfazeres p = dataSnapshot1.getValue(MeusAfazeres.class);
                    list.add(p);
                }
                adaptadorAfazeres = new AdaptadorAfazeres(ObjetivoActivity.this, list);
                seusafazeres.setAdapter(adaptadorAfazeres);
                adaptadorAfazeres.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // erro
                Toast.makeText(getApplicationContext(), "Sem Info", Toast.LENGTH_SHORT).show();
            }
        });
    }
}