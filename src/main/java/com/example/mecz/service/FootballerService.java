package com.example.mecz.service;

import com.example.mecz.Utils.Utils;
import com.example.mecz.exceptions.FootballerException;
import com.example.mecz.model.footballer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FootballerService {

    private NameSurnameService nameSurnameService;
    private ApiGateway apiGateway;

    public FootballerService(NameSurnameService nameSurnameService, ApiGateway apiGateway){
        this.nameSurnameService = nameSurnameService;
        this.apiGateway = apiGateway;
    }

    public Footballer createFootballer(FootballerPosition footballerPosition) {
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
                case MIDFIELDER:
                    footballer = new FootballerMidfielder();
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
            footballer.setNameSurname(nameDraw());

        }catch (Exception e){
            log.error(String.format("Nie udało się stworzyć piłkarza, z powodu: %s", e.getMessage()), e);
            throw new FootballerException(footballerPosition.name(), e.getMessage());
        }
        return footballer;
    }

    private String nameDraw(){
        int indexName = Utils.draw(1,5);
        String nameAndSurname;
        if(indexName < 4){
        nameAndSurname = nameSurnameService.createNameAndSurname();
        } else {
            nameAndSurname = apiGateway.createNames();
        }
        return nameAndSurname;
    }

}
