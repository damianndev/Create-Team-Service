package com.example.mecz.service;


import com.example.mecz.exceptions.CoachException;
import com.example.mecz.model.coach.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrenerSerwis {

    private ApiGateway apiGateway;

    public TrenerSerwis(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }


    public Coach stwórzTrenera(coachType coachType) {
        Coach coach;

        try {
            switch (coachType) {
                case OFFENSIVE:
                    coach = new CoachOfensywny();
                    break;
                case BALANCED:
                    coach = new CoachZrównoważony();
                    break;
                case DEFENSIVE:
                    coach = new CoachDefensywny();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + coachType);
            }

            createName(coach);
        } catch (Exception e) {
            //logowanie błędów + nie zjadanie ich
            log.error(String.format("Nie udało się stworzyć trenera, z powodu: %s", e.getMessage()), e);
            throw new CoachException(coachType.name(), e.getMessage());
        }

        return coach;
    }



    private Coach createName(Coach coach) {
        try {
            String name = apiGateway.createNames();
            coach.setNameSurname(name);
        } catch (Exception exception) {
            coach.setNameSurname("Paulo Sousa");
        }
        return coach;
    }
}