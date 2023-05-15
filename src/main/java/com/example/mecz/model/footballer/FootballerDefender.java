package com.example.mecz.model.footballer;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;


public class FootballerDefender extends Footballer {
    public FootballerDefender(){
        super(" ",ImmutableList.of(FootballerPosition.DEFENDER, FootballerPosition.DEFENSIVE_MIDFIELDER), Utils.draw(70,100),Utils.draw(1,30),Utils.draw(50,90),Utils.draw(70,100),100,Utils.draw(20,50));
    }
}
