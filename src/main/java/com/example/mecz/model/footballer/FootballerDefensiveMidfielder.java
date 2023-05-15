package com.example.mecz.model.footballer;

import com.google.common.collect.ImmutableList;
import com.example.mecz.Utils.Utils;

public class FootballerDefensiveMidfielder extends Footballer {
    public FootballerDefensiveMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.DEFENSIVE_MIDFIELDER, FootballerPosition.DEFENDER), Utils.draw(80,100),Utils.draw(1,20),Utils.draw(50,90),Utils.draw(80,100), 100,Utils.draw(40,80));
    }
}
