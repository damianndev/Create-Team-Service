package com.example.mecz.service;


import com.example.mecz.model.piłkarz.*;
import org.springframework.stereotype.Service;

@Service
public class PiłkarzSerwis {

    public Piłkarz stwórzPiłkarza(PozycjaPiłkarza pozycjaPiłkarza) {
        Piłkarz piłkarz;


        switch (pozycjaPiłkarza) {
            case BRAMKARZ:
                piłkarz = new PiłkarzBramkarz();
                break;
            case OBROŃCA:
                piłkarz = new PiłkarzObrońca();
                break;
            case DEFENSYWNY_POMOCNIK:
                piłkarz = new PiłkarzDefensywnyPomocnik();
                break;
            case POMOCNIK:
                piłkarz = new PiłkarzPomocnik();
                break;
            case OFENSYWNY_POMOCNIK:
                piłkarz = new PiłkarzOfensywnyPomocnik();
                break;
            case NAPASTNIK:
                piłkarz = new PiłkarzNapastnik();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pozycjaPiłkarza);
        }
        return piłkarz;
    }


}
