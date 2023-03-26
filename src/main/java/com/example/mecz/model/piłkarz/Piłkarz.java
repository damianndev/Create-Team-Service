package com.example.mecz.model.piłkarz;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Piłkarz {
    private String imieNazwisko;
    private ImmutableList pozycjePiłkarza;
    private int obrona;
    private int atak;
    private int szybkość;
    private int waleczność;
    private int kondycja;
    private int technika;


    public Piłkarz(String imieNazwisko, ImmutableList pozycjePiłkarza, int obrona, int atak, int szybkość, int waleczność, int kondycja, int technika){
        this.imieNazwisko = imieNazwisko;
        this.pozycjePiłkarza = pozycjePiłkarza;
        this.obrona = obrona;
        this.atak = atak;
        this.szybkość = szybkość;
        this.waleczność = waleczność;
        this.kondycja = kondycja;
        this.technika = technika;
    }
}
