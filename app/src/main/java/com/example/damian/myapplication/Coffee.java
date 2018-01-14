package com.example.damian.myapplication;

/**
 * Created by Damian on 2018-01-07.
 */

public class Coffee {


    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getNazwa_kawy() {
        return nazwa_kawy;
    }

    public void setNazwa_kawy(String nazwa_kawy) {
        this.nazwa_kawy = nazwa_kawy;
    }

    private String cena;

    private  String nazwa_kawy;

    Coffee(String cena, String nazwa_kawy)
    {
        this.cena = cena;
        this.nazwa_kawy = nazwa_kawy;

    }

}
