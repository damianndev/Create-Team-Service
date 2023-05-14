package com.example.mecz.model.coach;

import com.example.mecz.Utils.Utils;

public class BalancedCoach extends Coach {
    public BalancedCoach(){
        super(" ", CoachType.BALANCED, Utils.draw(40,60),Utils.draw(40,60),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100));
    }

}

