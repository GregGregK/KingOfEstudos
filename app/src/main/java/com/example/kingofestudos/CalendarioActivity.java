package com.example.kingofestudos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarioActivity extends AppCompatActivity implements AdaptadorCalendario.OnItemListener
{

    private TextView mesAnoText;
    private RecyclerView calendarioRecyclerView;
    private LocalDate selectedDate;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();

    }



    private void initWidgets()
    {
        calendarioRecyclerView = findViewById(R.id.calendarioRecyclerView);
        mesAnoText = findViewById(R.id.mesAnoTV);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView()
    {
        mesAnoText.setText(mesAnoDaData(selectedDate));
        ArrayList<String> diasNoMes =  diasNoMesArray(selectedDate);

        AdaptadorCalendario adaptadorCalendario = new AdaptadorCalendario(diasNoMes, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarioRecyclerView.setLayoutManager(layoutManager);
        calendarioRecyclerView.setAdapter(adaptadorCalendario);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> diasNoMesArray(LocalDate date)
    {
        ArrayList<String> diasNoMesArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int diasNoMes = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int diaDaSemana = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
          if(i <= diaDaSemana || i > diasNoMes + diaDaSemana)
          {
                diasNoMesArray.add("");
         }
          else
              {
              diasNoMesArray.add(String.valueOf(i - diaDaSemana));
        }
        }
        return  diasNoMesArray;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String mesAnoDaData(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void mesAnteriorAction(View view)
    {
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void proximoMesAction(View view)
    {
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String diaText)
    {
        if(diaText.equals(""))
        {
            String message = "Data selecionada" + diaText + " "+ mesAnoDaData(selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}