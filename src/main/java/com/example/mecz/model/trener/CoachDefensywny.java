package com.example.mecz.model.trener;

import com.example.mecz.Utils.Utils;

public class CoachDefensywny extends Coach {
    public CoachDefensywny(){
        super(" ", coachType.DEFENSIVE, Utils.losuj(70,100),Utils.losuj(1,30),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100));
    }

}


