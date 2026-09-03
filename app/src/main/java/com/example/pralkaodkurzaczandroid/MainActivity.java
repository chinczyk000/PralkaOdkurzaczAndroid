package com.example.pralkaodkurzaczandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumberPralka;
    Button buttonOdkurzaczOnOff;
    Button buttonZatwierdzPralka;
    TextView textViewOutputPralka;
    TextView textViewOdkurzaczOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNumberPralka = findViewById(R.id.editTextNumberPralka);
        buttonOdkurzaczOnOff = findViewById(R.id.buttonOdkurzaczOnOff);
        buttonZatwierdzPralka = findViewById(R.id.buttonZatwierdzPralka);
        String numerProgramuPrania = editTextNumberPralka.getText().toString();
        Odkurzacz odkurzacz = new Odkurzacz();
        Pralka pralka = new Pralka();
        if(odkurzacz.isCzyOdkurzaczJestWlaczony()){
            buttonOdkurzaczOnOff.setText(odkurzacz.on());
        }else{
            buttonOdkurzaczOnOff.setText(odkurzacz.off());
        }

        buttonOdkurzaczOnOff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(odkurzacz.isCzyOdkurzaczJestWlaczony()){
                            buttonOdkurzaczOnOff.setText(odkurzacz.off());
                            textViewOdkurzaczOnOff.setText("Odkurzacz wyłączony");
                        }else{
                            buttonOdkurzaczOnOff.setText(odkurzacz.on());
                            textViewOdkurzaczOnOff.setText("Odkurzacz włączony");
                        }
                    }
                }
        );

        buttonZatwierdzPralka.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        textViewOutputPralka.setText(pralka.wybierzNumerProgramuPrania(Integer.parseInt(numerProgramuPrania)));

                    }
                }
        );
    }
}