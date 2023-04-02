package com.example.mecz.model.piłkarz;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class FootballerGoalkeeper extends Footballer {
    public FootballerGoalkeeper(){
        super("", ImmutableList.of(FootballerPosition.GOALKEEPER, FootballerPosition.GOALKEEPER), Utils.losuj(70,100),Utils.losuj(1,5),Utils.losuj(20,40),Utils.losuj(70,100),100, Utils.losuj(1,20));
    }

}
