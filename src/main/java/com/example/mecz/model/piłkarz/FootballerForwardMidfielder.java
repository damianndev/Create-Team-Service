package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerForwardMidfielder extends Footballer {
    public FootballerForwardMidfielder(){
        super(" ",ImmutableList.of(FootballerPosition.FORWARD_MIDFIELDER, FootballerPosition.OFFENSIVE_MIDFIELDER), Utils.losuj(50,70),Utils.losuj(50,70),Utils.losuj(50,80),Utils.losuj(50,80),100,Utils.losuj(50,80));
}
}
