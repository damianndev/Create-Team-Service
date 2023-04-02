package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerDefender extends Footballer {
    public FootballerDefender(){
        super(" ",ImmutableList.of(FootballerPosition.DEFENDER, FootballerPosition.DEFENSIVE_MIDFIELDER), Utils.losuj(70,100),Utils.losuj(1,30),Utils.losuj(50,90),Utils.losuj(70,100),100,Utils.losuj(20,50));
    }
}
