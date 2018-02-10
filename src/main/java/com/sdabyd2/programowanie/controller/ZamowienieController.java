package com.sdabyd2.programowanie.controller;

import com.sdabyd2.programowanie.model.ZamowienieModel;
import com.sdabyd2.programowanie.view.ZamowienieView;

public class ZamowienieController {
    private ZamowienieModel zamowienieModel;
    private ZamowienieView zamowienieView;

    public ZamowienieController(ZamowienieModel zamowienieModel, ZamowienieView zamowienieView) {
        this.zamowienieModel = zamowienieModel;
        this.zamowienieView = zamowienieView;
    }
    public int getMaksRozmiar(){
        return zamowienieModel.getMaksRozmiar();
    }
    public void setMaksRozmiar(int maksRozmiar){
        this.zamowienieModel.setMaksRozmiar(maksRozmiar);
    }

    public void updateView(){

        this.zamowienieView.displayZAmowienie(zamowienieModel);
    }
}
