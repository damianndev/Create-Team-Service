package com.example.mecz.model.footballer;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;


public class FootballerStriker extends Footballer {
    public FootballerStriker(){
        super(" ",ImmutableList.of(FootballerPosition.STRIKER, FootballerPosition.OFFENSIVE_MIDFIELDER), Utils.draw(1,30),Utils.draw(70,100),Utils.draw(60,100),Utils.draw(50,100),100,Utils.draw(50,100));
    }
}
