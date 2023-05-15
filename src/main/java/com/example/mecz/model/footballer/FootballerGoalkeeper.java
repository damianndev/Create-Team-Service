package com.example.mecz.model.footballer;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;


public class FootballerGoalkeeper extends Footballer {
    public FootballerGoalkeeper(){
        super("", ImmutableList.of(FootballerPosition.GOALKEEPER, FootballerPosition.GOALKEEPER), Utils.draw(70,100),Utils.draw(1,5),Utils.draw(20,40),Utils.draw(70,100),100, Utils.draw(1,20));
    }

}
