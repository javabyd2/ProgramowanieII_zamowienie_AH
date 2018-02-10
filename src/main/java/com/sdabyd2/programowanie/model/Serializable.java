package com.sdabyd2.programowanie.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public interface Serializable {

    void zapiszZamowienie(ZamowienieModel z, String nazwaPliku);

    ZamowienieModel wczytajZamowienie(String nazwaPliku);
}
