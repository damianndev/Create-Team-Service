package com.example.mecz.model.trener;

import com.example.mecz.Utils.Utils;

public class TrenerDefensywny extends Trener{
    public TrenerDefensywny(){
        super(TypTrenera.DEFENSIVE, Utils.losuj(70,100),Utils.losuj(1,30),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100));
    }

}


