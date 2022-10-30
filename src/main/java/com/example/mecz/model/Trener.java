package com.example.mecz.model;

public abstract class Trener implements Trenuje{
    @Override
    public void trenuje(){
        //TODO: trener umie trenować
    }
    private int defensywa;
    private int ofensywa;
    private int motywowanie;
    private int taktyka;
    private int kondycja;
    private int technika;
    private int trening;

    public Trener (int defensywa, int ofensywa, int motywowanie, int taktyka, int kondycja, int technika, int trening){
        this.defensywa = defensywa;
        this.ofensywa = ofensywa;
        this.motywowanie = motywowanie;
        this.taktyka = taktyka;
        this.kondycja = kondycja;
        this.technika = technika;
        this.trening = trening;

    }
}
