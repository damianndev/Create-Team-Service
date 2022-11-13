package com.example.mecz.model.trener;

import com.example.mecz.Utils.Utils;

public class TrenerOfensywny extends Trener{
   public TrenerOfensywny(){
       super(TypTrenera.OFFENSIVE, Utils.losuj(1,30),Utils.losuj(70,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100));
   }

}
