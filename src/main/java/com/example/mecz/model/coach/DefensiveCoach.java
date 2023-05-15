package com.example.mecz.model.coach;

import com.example.mecz.Utils.Utils;

public class DefensiveCoach extends Coach {

    public DefensiveCoach(){
        super(" ", CoachType.DEFENSIVE, Utils.draw(70,100),Utils.draw(1,30),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100));
    }

}


