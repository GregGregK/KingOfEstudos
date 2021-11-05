package com.example.kingofestudos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NovoAfazerActivity extends AppCompatActivity {

    TextView tituloPagina, addtitulo, adddesc, adddata;
    EditText tituloafazer, descafazer, dataafazer;
    Button btnSalvarAfazer, btnCancelar;
    DatabaseReference reference;
    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_afazer);

        tituloPagina = findViewById(R.id.tituloPagina);
        addtitulo = findViewById(R.id.addtitulo);
        adddesc = findViewById(R.id.adddesc);
        adddata = findViewById(R.id.adddata);

        descafazer = findViewById(R.id.descafazer);
        tituloafazer = findViewById(R.id.tituloafazer);
        dataafazer = findViewById(R.id.dataafazer);

        btnSalvarAfazer = findViewById(R.id.btnSalvarAfazer);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NovoAfazerActivity.this , ObjetivoActivity.class));
                finish();
            }
        });

        btnSalvarAfazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inserir data para o banco de dados
                reference = FirebaseDatabase.getInstance().getReference().child("KingOfEstuddos").
                        child("Does" + doesNum);

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("tituloafazer").setValue(tituloafazer.getText().toString());
                        dataSnapshot.getRef().child("descafazer").setValue(descafazer.getText().toString());
                        dataSnapshot.getRef().child("dataafazer").setValue(dataafazer.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        Intent a = new Intent(NovoAfazerActivity.this,ObjetivoActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        //importar fonte
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/montserrat_light.otf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/montserrat_medium.otf");

        //customizar fonte
        tituloPagina.setTypeface(MMedium);

        addtitulo.setTypeface(MLight);
        tituloafazer.setTypeface(MMedium);

        adddesc.setTypeface(MLight);
        descafazer.setTypeface(MMedium);

        adddata.setTypeface(MLight);
        descafazer.setTypeface(MMedium);

        btnSalvarAfazer.setTypeface(MLight);
        btnCancelar.setTypeface(MMedium);
    }
}