package com.example.kingofestudos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditarTaskDesk extends AppCompatActivity {


    EditText tituloAfazer, descAfazer, dataAfazer;
    Button btnSalvarAfazer, btnDelete;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_task_desk);

        tituloAfazer = findViewById(R.id.tituloafazer);
        descAfazer = findViewById(R.id.descafazer);
        dataAfazer = findViewById(R.id.dataafazer);

        btnSalvarAfazer = findViewById(R.id.btnSalvarAfazer);
        btnDelete = findViewById(R.id.btnDelete);

        // pegar valor da pagina anterior
        tituloAfazer.setText(getIntent().getStringExtra("tituloafazer"));
        descAfazer.setText(getIntent().getStringExtra("descafazer"));
        dataAfazer.setText(getIntent().getStringExtra("dataafazer"));

       final String keykeyDoes = getIntent().getStringExtra("Keydoes");
        reference = FirebaseDatabase.getInstance().getReference().child("KingOfEstudos").
                child("Does" + keykeyDoes);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent a = new Intent(EditarTaskDesk.this,ObjetivoActivity.class);
                            startActivity(a);
                        } else {
                            Toast.makeText(getApplicationContext(), "Falha", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        //evento para o botão
        btnSalvarAfazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().child("KingOfEstudos").
                        child("Does" + keykeyDoes);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("tituloafazer").setValue(tituloAfazer.getText().toString());
                        dataSnapshot.getRef().child("descafazer").setValue(descAfazer.getText().toString());
                        dataSnapshot.getRef().child("dataafazer").setValue(dataAfazer.getText().toString());
                        Intent a = new Intent(EditarTaskDesk.this,ObjetivoActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}