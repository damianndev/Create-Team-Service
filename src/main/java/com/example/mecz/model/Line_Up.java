package com.example.mecz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Line_Up {
    JEDEN_CZTERY_CZTERY_DWA(1,1,4,0,4,0,2),
    JEDEN_TRZY_CZTERY_TRZY(2,1,3,0,4,0,3),
    JEDEN_CZTERY_PIĘĆ_JEDEN(3,1,4,0,5,0,1),
    JEDEN_CZTERY_TRZY_TRZY(4,1,4,0,3,0,3),
    JEDEN_TRZY_PIĘĆ_JEDEN_JEDEN(5,1,3,0,5,1,1),
    JEDEN_CZTERY_DWA_TRZY_JEDEN(6,1,4,2,0,3,1),
    JEDEN_CZTERY_CZTERY_JEDEN_JEDEN(7,1,4,0,4,1,1),
    JEDEN_CZTERY_JEDEN_CZTERY_JEDEN(8,1,4,1,4,0,1),
    DIAMENT(9,1,4,1,2,1,2);


    private Integer lineupNumber;
    private Integer goalkeeper;
    private Integer numberOfDefenders;
    private Integer numberOfDefensiveMidfielders;
    private Integer numberOfMidfielders;
    private Integer numberOfOffensiveMidfielders;
    private Integer numberOfStrikers;




}




