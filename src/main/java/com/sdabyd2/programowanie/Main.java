package com.sdabyd2.programowanie;

import com.sdabyd2.programowanie.controller.ZamowienieController;
import com.sdabyd2.programowanie.model.PozycjaModel;
import com.sdabyd2.programowanie.model.Serializable;
import com.sdabyd2.programowanie.model.ZamowienieModel;
import com.sdabyd2.programowanie.view.ZamowienieView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PozycjaModel p1 = new PozycjaModel("Chleb", 1, 3.5);
        PozycjaModel p2 = new PozycjaModel("Cukier", 3, 4);
        PozycjaModel p3 = new PozycjaModel("Sok pomarańczowy", 6, 3.20);
        ZamowienieModel z = new ZamowienieModel(20);
        ZamowienieView zamowienieView = new ZamowienieView();
        ZamowienieController controller = new ZamowienieController(z, zamowienieView);

        z.dodajPozycjeLubZwiększLiczbeSztuk(p1);
        z.dodajPozycjeLubZwiększLiczbeSztuk(p2);
        z.usunPozycje(1);
        controller.updateView();
        z.edytujPozycje(0, "Herbata zielona", 12.50, 1);
        z.dodajPozycje(p3);
        z.dodajPozycjeLubZwiększLiczbeSztuk(new PozycjaModel("sok pomarańczowy", 4, 3.20));
        controller.updateView();
        z.zapiszZamowienie(z,"nowyJSON.json");

        ZamowienieModel z1 = new ZamowienieModel();
        ZamowienieModel z2 = z1.wczytajZamowienie("zamowienie.json");
        ZamowienieController controller2 = new ZamowienieController(z2,zamowienieView);
        controller2.updateView();
    }
}
