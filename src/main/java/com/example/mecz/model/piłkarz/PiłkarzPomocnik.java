package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class PiłkarzPomocnik extends Piłkarz{
    public PiłkarzPomocnik(){
        super(ImmutableList.of(PozycjaPiłkarza.POMOCNIK,PozycjaPiłkarza.OFENSYWNY_POMOCNIK), Utils.losuj(50,70),Utils.losuj(50,70),Utils.losuj(50,80),Utils.losuj(50,80),100,Utils.losuj(50,80));
    }
}
