package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerOffensiveMidfielder extends Footballer {
    public FootballerOffensiveMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.OFFENSIVE_MIDFIELDER, FootballerPosition.STRIKER), Utils.losuj(10,50),Utils.losuj(60,90),Utils.losuj(60,90),Utils.losuj(50,80),100,Utils.losuj(70,100));
    }
}
