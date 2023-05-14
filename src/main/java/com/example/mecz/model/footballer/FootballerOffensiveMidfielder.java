package com.example.mecz.model.footballer;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerOffensiveMidfielder extends Footballer {
    public FootballerOffensiveMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.OFFENSIVE_MIDFIELDER, FootballerPosition.STRIKER), Utils.draw(10,50),Utils.draw(60,90),Utils.draw(60,90),Utils.draw(50,80),100,Utils.draw(70,100));
    }
}
