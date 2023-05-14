package com.example.mecz.model.coach;

import com.example.mecz.Utils.Utils;

public class OffensiveCoach extends Coach {
   public OffensiveCoach(){
       super(" ", CoachType.OFFENSIVE, Utils.draw(1,30),Utils.draw(70,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100),Utils.draw(1,100));
   }

}
