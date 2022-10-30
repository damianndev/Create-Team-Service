package com.example.mecz.model;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class PiłkarzObrońca extends Piłkarz{
    public PiłkarzObrońca(){
        super(ImmutableList.of(PozycjaPiłkarza.OBROŃCA,PozycjaPiłkarza.DEFENSYWNY_POMOCNIK), Utils.losuj(70,100),Utils.losuj(1,30),Utils.losuj(50,90),Utils.losuj(70,100),100,Utils.losuj(20,50));
    }
}
