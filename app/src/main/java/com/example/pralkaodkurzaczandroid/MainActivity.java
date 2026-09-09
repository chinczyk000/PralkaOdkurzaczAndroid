package com.example.pralkaodkurzaczandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
        textViewOutputPralka = findViewById(R.id.textViewOutputPralka);
        textViewOdkurzaczOnOff = findViewById(R.id.textViewOdkurzaczOnOff);

        Odkurzacz odkurzacz = new Odkurzacz();
        Pralka pralka = new Pralka();

        if (odkurzacz.isCzyOdkurzaczJestWlaczony()) {
            buttonOdkurzaczOnOff.setText(odkurzacz.off());
            textViewOdkurzaczOnOff.setText("Odkurzacz włączony");
        } else {
            buttonOdkurzaczOnOff.setText(odkurzacz.on());
            textViewOdkurzaczOnOff.setText("Odkurzacz wyłączony");
        }

        buttonOdkurzaczOnOff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (odkurzacz.isCzyOdkurzaczJestWlaczony()) {
                            buttonOdkurzaczOnOff.setText(odkurzacz.off());
                            textViewOdkurzaczOnOff.setText("Odkurzacz wyłączony");
                        } else {
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

                        String numerProgramuPrania =
                                editTextNumberPralka.getText().toString();

                        if (numerProgramuPrania.isEmpty()) {
                            textViewOutputPralka.setText("Podaj numer programu");
                            return;
                        }

                        int numer = Integer.parseInt(numerProgramuPrania);

                        int wynik = pralka.wybierzNumerProgramuPrania(numer);

                        if (wynik >= 1 && wynik <= 12) {
                            textViewOutputPralka.setText(
                                    "Wybrano program: " + wynik
                            );
                        } else {
                            textViewOutputPralka.setText(
                                    "Niepoprawny numer programu"
                            );
                        }
                    }
                }
        );
    }
}
