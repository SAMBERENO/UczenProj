package com.example;

import java.util.ArrayList;
import java.util.List;

public class Uczen {

    private String imie;
    private int wiek;
    private List<Integer> oceny;

    private void ustawWiekiOceny(int wiek, List<Integer> oceny){
        if(wiek < 0){
            this.wiek = 0;
        } else {
            this.wiek = wiek;
        }
        if(oceny == null){
            this.oceny = new ArrayList<>();
        } else {
            this.oceny = new ArrayList<>(oceny);
        }
    }

    public Uczen(){
        this("Brak", 0, null);
    }

    public Uczen(String imie, int wiek){
        this(imie, wiek, null);
    }

    public Uczen(String imie, int wiek, List<Integer> oceny){
        ustawWiekiOceny(wiek, oceny);
        this.imie = imie;
    }

    public void dodajOcene(int ocena){
        if(ocena < 1 || ocena > 6){
            return;
        } else {
            oceny.add(ocena);
        }
    }

    public double obliczSrednia(){
        int suma = 0;
        double srednia = 0.0;
        if(oceny.isEmpty()){
            return 0.0;
        } else {
            for(int ocena : oceny){
                suma += ocena;
            }
            srednia = (double) suma / oceny.size();
        }
        return srednia;
    }

    public boolean maOceny(){
        return !oceny.isEmpty();
    }

    public void postarzejSie(){
        this.wiek++;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public List<Integer> getOceny() {
        return new ArrayList<>(oceny);
    }

}
