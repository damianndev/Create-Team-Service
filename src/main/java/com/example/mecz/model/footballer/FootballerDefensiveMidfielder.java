package com.example.mecz.model.footballer;
import com.google.common.collect.ImmutableList;

import com.example.mecz.Utils.Utils;

public class FootballerDefensiveMidfielder extends Footballer {
    public FootballerDefensiveMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.DEFENSIVE_MIDFIELDER, FootballerPosition.DEFENDER), Utils.losuj(80,100),Utils.losuj(1,20),Utils.losuj(50,90),Utils.losuj(80,100), 100,Utils.losuj(40,80));
    }
}
