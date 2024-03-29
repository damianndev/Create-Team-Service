package com.example.mecz.model.coach;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Coach {

    private String nameSurname;
    private CoachType CoachType;
    private int defense;
    private int offense;
    private int motivating;
    private int tactics;
    private int physical_condition;
    private int technique;
    private int practice;

    public Coach(String nameSurname, CoachType coachType, int defense, int offense, int motivating, int tactics, int physical_condition, int technique, int practice){
        this.nameSurname = nameSurname;
        this.CoachType = coachType;
        this.defense = defense;
        this.offense = offense;
        this.motivating = motivating;
        this.tactics = tactics;
        this.physical_condition = physical_condition;
        this.technique = technique;
        this.practice = practice;

    }
}
