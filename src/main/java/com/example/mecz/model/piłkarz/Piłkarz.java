package com.example.mecz.model.piłkarz;

import com.google.common.collect.ImmutableList;

public abstract class Piłkarz {
    private ImmutableList pozycjePiłkarza;
    private int obrona;
    private int atak;
    private int szybkość;
    private int waleczność;
    private int kondycja;
    private int technika;


    public Piłkarz(ImmutableList pozycjePiłkarza, int obrona, int atak, int szybkość, int waleczność, int kondycja, int technika){
        this.pozycjePiłkarza = pozycjePiłkarza;
        this.obrona = obrona;
        this.atak = atak;
        this.szybkość = szybkość;
        this.waleczność = waleczność;
        this.kondycja = kondycja;
        this.technika = technika;
    }
}
