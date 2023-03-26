package com.example.mecz.service;


import com.example.mecz.Utils.Utils;
import com.example.mecz.exceptions.PiłkarzException;
import com.example.mecz.model.piłkarz.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PiłkarzSerwis {

    private ImieNazwiskoSerwis imieNazwiskoSerwis;
    private ApiGateway apiGateway;


    public PiłkarzSerwis(ImieNazwiskoSerwis imieNazwiskoSerwis, ApiGateway apiGateway){
        this.imieNazwiskoSerwis = imieNazwiskoSerwis;
        this.apiGateway = apiGateway;
    }

    public Piłkarz stwórzPiłkarza(PozycjaPiłkarza pozycjaPiłkarza) {
        Piłkarz piłkarz;

        try {
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
            //String nameAndSurname = imieNazwiskoSerwis.createNameAndSurname();
            piłkarz.setImieNazwisko(losowanieName());

        }catch (Exception e){
            log.error(String.format("Nie udało się stworzyć piłkarza, z powodu: %s", e.getMessage()), e);
            throw new PiłkarzException(pozycjaPiłkarza.name(), e.getMessage());
        }


        return piłkarz;


    }


    private String losowanieName (){
        int indexName = Utils.losuj(1,5);
        String nameAndSurname;
        if(indexName < 4){
        nameAndSurname = imieNazwiskoSerwis.createNameAndSurname();
        } else {
            nameAndSurname = apiGateway.createNames();
        }
        return nameAndSurname;
    }

}
