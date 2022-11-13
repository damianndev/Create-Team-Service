package com.example.mecz.model.trener;

import com.example.mecz.Utils.Utils;

public class TrenerZrównoważony extends Trener{
    public TrenerZrównoważony(){
        super(TypTrenera.BALANCED, Utils.losuj(40,60),Utils.losuj(40,60),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100));
    }

}

