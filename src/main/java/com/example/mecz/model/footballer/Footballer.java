package com.example.mecz.model.footballer;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Footballer {
    private String nameSurname;
    private ImmutableList footballerPositions;
    private int defence;
    private int attack;
    private int speed;
    private int aggressive;
    private int physical_condition;
    private int technique;


    public Footballer(String nameSurname, ImmutableList footballerPositions, int defence, int attack, int speed, int aggressive, int physical_condition, int technique){
        this.nameSurname = nameSurname;
        this.footballerPositions = footballerPositions;
        this.defence = defence;
        this.attack = attack;
        this.speed = speed;
        this.aggressive = aggressive;
        this.physical_condition = physical_condition;
        this.technique = technique;
    }
}
