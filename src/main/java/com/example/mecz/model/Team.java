package com.example.mecz.model;

import com.example.mecz.model.footballer.Footballer;
import com.example.mecz.model.coach.Coach;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Team {
    private Line_Up lineUp;
    private List<Footballer> footballers;
    private Coach coach;

    public Team(Line_Up lineUp, List<Footballer> footballers, Coach coach){
        this.lineUp = lineUp;
        this.footballers = footballers;
        this.coach = coach;
    }






}
