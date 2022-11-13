package com.example.mecz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Ustawienie {
    JEDEN_CZTERY_CZTERY_DWA(1,1,4,0,4,0,2),
    JEDEN_TRZY_CZTERY_TRZY(2,1,3,0,4,0,3),
    JEDEN_CZTERY_PIĘĆ_JEDEN(3,1,4,0,5,0,1),
    JEDEN_CZTERY_TRZY_TRZY(4,1,4,0,3,0,3),
    JEDEN_TRZY_PIĘĆ_JEDEN(5,1,3,0,5,0,1),
    JEDEN_CZTERY_DWA_TRZY_JEDEN(6,1,4,2,0,3,1),
    JEDEN_CZTERY_CZTERY_JEDEN_JEDEN(7,1,4,0,4,1,1),
    JEDEN_CZTERY_JEDEN_CZTERY_JEDEN(8,1,4,1,4,0,1),
    DIAMENT(9,1,4,1,2,1,2);


    private Integer nrUstawienia;
    private Integer bramkarz;
    private Integer liczbaObrońców;
    private Integer liczbaDefensywnychPomocników;
    private Integer liczbaPomocników;
    private Integer liczbaOfensywnychPomocników;
    private Integer liczbaNapastników;




}

//TODO: controller który zwróci ustawienie poprzez postmana, na przykładzie kontrolera z wyścigu tam gdzie liczba


