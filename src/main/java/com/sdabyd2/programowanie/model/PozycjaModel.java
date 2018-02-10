package com.sdabyd2.programowanie.model;
import lombok.Getter;
import lombok.Setter;

import java.util.Formatter;

@Getter
@Setter
public class PozycjaModel {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;
    private int rabat;

    public PozycjaModel(){}

    public PozycjaModel(String nazwa, int ilosc, double cena){
        this.nazwaTowaru = nazwa;
        this.ileSztuk = ilosc;
        this.cena = cena;
    }
    public double obliczWartosc(){
        double result = cena*ileSztuk;
        return result;
    }
    public double obliczWartoscZRabatem(){
        double result = obliczWartosc();
        if (ileSztuk>=5&&ileSztuk<=10) {
            result = obliczWartosc() * 0.95;
            rabat = 5;
        }else if (ileSztuk>10&&ileSztuk<=20) {
            result = obliczWartosc()*0.9;
            rabat = 10;
        }else if (ileSztuk>20) {
            result = obliczWartosc()*0.85;
            rabat = 15;
        }
            return result;
    }

    public String toString(){
                return String.format("%20s %10.2f zł %4d szt %10.2f zł Naliczono rabat %4d procent\n",
                        nazwaTowaru,
                        cena,
                        ileSztuk,
                        obliczWartoscZRabatem(),
                        rabat);
    }
}
