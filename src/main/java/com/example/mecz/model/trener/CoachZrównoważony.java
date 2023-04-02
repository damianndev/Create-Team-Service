package com.example.mecz.model.trener;

import com.example.mecz.Utils.Utils;

public class CoachZrównoważony extends Coach {
    public CoachZrównoważony(){
        super(" ", coachType.BALANCED, Utils.losuj(40,60),Utils.losuj(40,60),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100),Utils.losuj(1,100));
    }

}

