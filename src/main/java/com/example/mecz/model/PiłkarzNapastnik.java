package com.example.mecz.model;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class PiłkarzNapastnik extends Piłkarz{
    public PiłkarzNapastnik(){
        super(ImmutableList.of(PozycjaPiłkarza.NAPASTNIK,PozycjaPiłkarza.OFENSYWNY_POMOCNIK), Utils.losuj(1,30),Utils.losuj(70,100),Utils.losuj(60,100),Utils.losuj(50,100),100,Utils.losuj(50,100));
    }
}
