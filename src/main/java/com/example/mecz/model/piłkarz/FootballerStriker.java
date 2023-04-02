package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerStriker extends Footballer {
    public FootballerStriker(){
        super(" ",ImmutableList.of(FootballerPosition.STRIKER, FootballerPosition.OFFENSIVE_MIDFIELDER), Utils.losuj(1,30),Utils.losuj(70,100),Utils.losuj(60,100),Utils.losuj(50,100),100,Utils.losuj(50,100));
    }
}
