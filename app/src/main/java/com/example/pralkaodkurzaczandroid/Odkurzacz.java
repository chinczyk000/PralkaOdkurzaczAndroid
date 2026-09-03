package com.example.pralkaodkurzaczandroid;

public class Odkurzacz extends Urzadzenie{
    private boolean czyOdkurzaczJestWlaczony = false;
    public String on(){
        if(czyOdkurzaczJestWlaczony == false){
            this.czyOdkurzaczJestWlaczony = true;
            return "Wyłącz";
        }else{
            return "Włącz";
        }
    }
    public String off(){
        if(czyOdkurzaczJestWlaczony == true){
            this.czyOdkurzaczJestWlaczony = false;
            return "Włącz";
        }else{
            return "Wyłącz";
        }

    }

    public boolean isCzyOdkurzaczJestWlaczony() {
        return czyOdkurzaczJestWlaczony;
    }
}
