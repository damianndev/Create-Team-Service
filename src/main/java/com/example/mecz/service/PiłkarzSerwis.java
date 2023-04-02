package com.example.mecz.service;


import com.example.mecz.Utils.Utils;
import com.example.mecz.exceptions.FootballerException;
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

    public Footballer stwórzPiłkarza(FootballerPosition footballerPosition) {
        Footballer footballer;

        try {
            switch (footballerPosition) {
                case GOALKEEPER:
                    footballer = new FootballerGoalkeeper();
                    break;
                case DEFENDER:
                    footballer = new FootballerDefender();
                    break;
                case DEFENSIVE_MIDFIELDER:
                    footballer = new FootballerDefensiveMidfielder();
                    break;
                case FORWARD_MIDFIELDER:
                    footballer = new FootballerForwardMidfielder();
                    break;
                case OFFENSIVE_MIDFIELDER:
                    footballer = new FootballerOffensiveMidfielder();
                    break;
                case STRIKER:
                    footballer = new FootballerStriker();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + footballerPosition);
            }
            //String nameAndSurname = imieNazwiskoSerwis.createNameAndSurname();
            footballer.setNameSurname(losowanieName());

        }catch (Exception e){
            log.error(String.format("Nie udało się stworzyć piłkarza, z powodu: %s", e.getMessage()), e);
            throw new FootballerException(footballerPosition.name(), e.getMessage());
        }


        return footballer;


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
