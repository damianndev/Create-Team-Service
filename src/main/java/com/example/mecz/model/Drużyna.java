package com.example.mecz.model;

import com.example.mecz.model.piłkarz.Piłkarz;
import com.example.mecz.model.trener.Trener;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Drużyna {
    private Ustawienie ustawienie;
    private List<Piłkarz> piłkarze;
    private Trener trener;

    public Drużyna(Ustawienie ustawienie, List<Piłkarz> piłkarze, Trener trener ){
        this.ustawienie = ustawienie;
        this.piłkarze = piłkarze;
        this.trener = trener;
    }






}
