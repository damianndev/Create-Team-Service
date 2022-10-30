package com.example.mecz.model;
import com.google.common.collect.ImmutableList;

import com.example.mecz.Utils.Utils;

public class PiłkarzDefensywnyPomocnik extends Piłkarz{
    public PiłkarzDefensywnyPomocnik(){
        super(ImmutableList.of(PozycjaPiłkarza.DEFENSYWNY_POMOCNIK,PozycjaPiłkarza.OBROŃCA), Utils.losuj(80,100),Utils.losuj(1,20),Utils.losuj(50,90),Utils.losuj(80,100), 100,Utils.losuj(40,80));
    }
}
