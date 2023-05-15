package com.example.mecz.model.footballer;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerMidfielder extends Footballer {
    public FootballerMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.MIDFIELDER, FootballerPosition.OFFENSIVE_MIDFIELDER), Utils.draw(50,70),Utils.draw(50,70),Utils.draw(50,80),Utils.draw(50,80),100,Utils.draw(50,80));
    }
}
