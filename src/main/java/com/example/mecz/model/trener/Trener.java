package com.example.mecz.model.trener;

public abstract class Trener {

    private TypTrenera typTrenera;
    private int defensywa;
    private int ofensywa;
    private int motywowanie;
    private int taktyka;
    private int kondycja;
    private int technika;
    private int trening;

    public Trener (TypTrenera typTrenera, int defensywa, int ofensywa, int motywowanie, int taktyka, int kondycja, int technika, int trening){
        this.typTrenera = typTrenera;
        this.defensywa = defensywa;
        this.ofensywa = ofensywa;
        this.motywowanie = motywowanie;
        this.taktyka = taktyka;
        this.kondycja = kondycja;
        this.technika = technika;
        this.trening = trening;

    }
}
