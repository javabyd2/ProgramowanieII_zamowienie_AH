package com.sdabyd2.programowanie.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZamowienieModel implements Serializable {
    private List<PozycjaModel>listOfPozycjaModels;
    //private int ileDanych;
    private int maksRozmiar =10;

    public ZamowienieModel(){
        this.listOfPozycjaModels = new ArrayList<>();
    }

    public ZamowienieModel(int maxRozmiar){
        this.maksRozmiar = maxRozmiar;
        this.listOfPozycjaModels = new ArrayList<>();
    }
    public List<PozycjaModel> getListOfPozycjaModels() {
        return listOfPozycjaModels;
    }

    public void setListOfPozycjaModels(List<PozycjaModel> listOfPozycjaModels) {
        this.listOfPozycjaModels = listOfPozycjaModels;
    }

    public int getMaksRozmiar() {
        return maksRozmiar;
    }

    public void setMaksRozmiar(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
    }

    public void dodajPozycje(PozycjaModel p){
        listOfPozycjaModels.add(p);
    }
    public double obliczWartosc(){
        double wartosc = 0;
        for (int i = 0; i<listOfPozycjaModels.size();i++){
            wartosc += listOfPozycjaModels.get(i).obliczWartoscZRabatem();
        }return wartosc;
    }
    public void usunPozycje(int index){
        listOfPozycjaModels.remove(index);
    }
    public void edytujPozycje(int index, String nazwa, double cena, int liczbaSztuk){
        listOfPozycjaModels.get(index).setNazwaTowaru(nazwa);
        listOfPozycjaModels.get(index).setCena(cena);
        listOfPozycjaModels.get(index).setIleSztuk(liczbaSztuk);
    }
    public void dodajPozycjeLubZwiększLiczbeSztuk(PozycjaModel l){
        boolean czyIstniejePozycja = false;
        int indeksZduplikowanejPozycji = 0;
        for (int i =0; i<listOfPozycjaModels.size(); i++) {
            if (l.getNazwaTowaru().equalsIgnoreCase(listOfPozycjaModels.get(i).getNazwaTowaru())){
                czyIstniejePozycja = true;
                indeksZduplikowanejPozycji = i;
            } else {}
        }
        if (czyIstniejePozycja==true) {
            int ilośćPierwotna = listOfPozycjaModels.get(indeksZduplikowanejPozycji).getIleSztuk();
            listOfPozycjaModels.get(indeksZduplikowanejPozycji).setIleSztuk(ilośćPierwotna + l.getIleSztuk());
        }else {
            listOfPozycjaModels.add(l);
        }
    }

    @Override
    public String toString() {
        return "\nZamówienie:" + "\n" + listOfPozycjaModels + "\n" + "Razem: " + obliczWartosc() + "zł";
    }

    @Override
    public void zapiszZamowienie(ZamowienieModel z, String nazwaPliku) {
        ObjectMapper mapper = new ObjectMapper();
        File fileName = new File(nazwaPliku);
        try {
            fileName.createNewFile();
            mapper.writeValue(fileName,z);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ZamowienieModel wczytajZamowienie(String nazwaPliku) {

        ZamowienieModel zamowienieModel= new ZamowienieModel();
        ObjectMapper mapper = new ObjectMapper();

            try {
                zamowienieModel = mapper.readValue(new File(nazwaPliku), ZamowienieModel.class);
            }catch(IOException exception){
                exception.getStackTrace();
            }
        return zamowienieModel;
    }
}
