package com.example.mecz.model.trener;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Trener {

    private String imieNazwisko;
    private TypTrenera typTrenera;
    private int defensywa;
    private int ofensywa;
    private int motywowanie;
    private int taktyka;
    private int kondycja;
    private int technika;
    private int trening;

    public Trener (String imieNazwisko, TypTrenera typTrenera, int defensywa, int ofensywa, int motywowanie, int taktyka, int kondycja, int technika, int trening){
        this.imieNazwisko = imieNazwisko;
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
