package com.example.mecz.model;

import com.example.mecz.Utils.Utils;
import com.google.common.collect.ImmutableList;

public class PiłkarzBramkarz extends Piłkarz implements Broni {
    public PiłkarzBramkarz(){
        super(ImmutableList.of(PozycjaPiłkarza.BRAMKARZ,PozycjaPiłkarza.BRAMKARZ), Utils.losuj(70,100),Utils.losuj(1,5),Utils.losuj(20,40),Utils.losuj(70,100),100, Utils.losuj(1,20));
    }

    @Override
    public void broni(){
        //TODO:bramkarz umie bronić (może losowanie jakiś zakres który im większy się wylosuje tym mniejsze prawdopodobieństwo gola)
        // narazie void ale później pewnie int
    }
}
