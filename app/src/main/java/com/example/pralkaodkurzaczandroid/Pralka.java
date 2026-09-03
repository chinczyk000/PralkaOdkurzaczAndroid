package com.example.pralkaodkurzaczandroid;

public class Pralka extends Urzadzenie{
    private int numerProgramuPrania = 0;

    public int wybierzNumerProgramuPrania(int numerProgramuPrania) {
        if(numerProgramuPrania < 1 || numerProgramuPrania > 12){
            wyswietlKomunikat("Niepoprawny numer programu");
        }else{
            this.numerProgramuPrania = numerProgramuPrania;
        }
        return numerProgramuPrania;
    }
}

