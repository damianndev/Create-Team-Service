package com.example.mecz.service;

import com.example.mecz.exceptions.CoachException;
import com.example.mecz.exceptions.GoalkeeperException;
import com.example.mecz.exceptions.Line_upException;
import com.example.mecz.model.Team;
import com.example.mecz.model.Line_Up;
import com.example.mecz.model.footballer.Footballer;
import com.example.mecz.model.footballer.FootballerPosition;
import com.example.mecz.model.coach.Coach;
import com.example.mecz.model.coach.CoachType;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TeamService {

    private static final Integer ADDITIONAL_GOALKEEPER = 2;
    private static final Integer ADDITIONAL_DEFENDER = 4;
    private static final Integer ADDITIONAL_DEFENSIVE_MIDFIELDER = 2;
    private static final Integer ADDITIONAL_MIDFIELDER = 4;
    private static final Integer ADDITIONAL_OFFENSIVE_MIDFIELDER = 2;
    private static final Integer ADDITIONAL_STRIKER = 2;

    private FootballerService footballerService;
    private CoachService coachService;
    private ApiGateway apiGateway;

    public TeamService(FootballerService footballerService, CoachService coachService, ApiGateway apiGateway) {
        this.footballerService = footballerService;
        this.coachService = coachService;
        this.apiGateway = apiGateway;
    }

    public Team createTeam(String coachType, Integer lineupNumber) {
        Line_Up lineUp = mapToLineup(lineupNumber);
        List<Footballer> footballers = createFootballers(lineUp);
        Coach coach = createCoach(coachType);
        return new Team(lineUp, footballers, coach);
    }

    public Coach createCoach(String coachType) {
        try {
            Coach coach = coachService.createCoach(CoachType.valueOf(coachType));
            return coach;
        } catch (Exception exception) {
            throw new CoachException(coachType, exception.getMessage());
        }
    }

    public Line_Up mapToLineup(Integer nrUstawienia) {
        List<Line_Up> lineups = new ArrayList<>(Arrays.asList(Line_Up.values()));
        Line_Up lineUp = lineups.stream()
                .filter(l -> l.getLineupNumber().equals(nrUstawienia))
                .findFirst()
                .orElseThrow(() -> new Line_upException(nrUstawienia));
        return lineUp;
    }

    private List<Footballer> createFootballers(Line_Up lineUp) {
        Integer numberOfGolkeepers = lineUp.getGoalkeeper();
        Integer numberOfDefenders = lineUp.getNumberOfDefenders();
        Integer numberOfDefensiveMidfielder = lineUp.getNumberOfDefensiveMidfielders();
        Integer numberOfMidfielder = lineUp.getNumberOfMidfielders();
        Integer numberOfOffensiveMidfielder = lineUp.getNumberOfOffensiveMidfielders();
        Integer numberOfForwards = lineUp.getNumberOfStrikers();

        List<Footballer> listOfFootballers = new ArrayList<>();

        if (numberOfGolkeepers > 0) {
            for (int i = 0; i < numberOfGolkeepers + ADDITIONAL_GOALKEEPER; i++) {
                Footballer bramkarz = footballerService.createFootballer(FootballerPosition.GOALKEEPER);
                listOfFootballers.add(bramkarz);
            }
        } else {
            throw new GoalkeeperException();
        }
        if (numberOfDefenders > 0) {
            for (int i = 0; i < numberOfDefenders + ADDITIONAL_DEFENDER; i++) {
                Footballer defender = footballerService.createFootballer(FootballerPosition.DEFENDER);
                listOfFootballers.add(defender);
            }
        }
        if (numberOfDefensiveMidfielder > 0) {
            for (int i = 0; i < numberOfDefensiveMidfielder + ADDITIONAL_DEFENSIVE_MIDFIELDER; i++) {
                Footballer defensiveMidfielder = footballerService.createFootballer(FootballerPosition.DEFENSIVE_MIDFIELDER);
                listOfFootballers.add(defensiveMidfielder);
            }
        }
        if (numberOfMidfielder > 0) {
            for (int i = 0; i < numberOfMidfielder + ADDITIONAL_MIDFIELDER; i++) {
                Footballer midfielder = footballerService.createFootballer(FootballerPosition.MIDFIELDER);
                listOfFootballers.add(midfielder);
            }
        }
        if (numberOfOffensiveMidfielder > 0) {
            for (int i = 0; i < numberOfOffensiveMidfielder + ADDITIONAL_OFFENSIVE_MIDFIELDER; i++) {
                Footballer offensiveMidfielder = footballerService.createFootballer(FootballerPosition.OFFENSIVE_MIDFIELDER);
                listOfFootballers.add(offensiveMidfielder);
            }
        }
        if (numberOfForwards > 0) {
            for (int i = 0; i < numberOfForwards + ADDITIONAL_STRIKER; i++) {
                Footballer striker = footballerService.createFootballer(FootballerPosition.STRIKER);
                listOfFootballers.add(striker);
            }
        }
        return filterNames(listOfFootballers);
    }

    private List<Footballer> filterNames (List<Footballer> footballersList){
        int counter = 1;
        for (Footballer footballer : footballersList) {
            counter = checkNames(footballersList, counter, footballer);
        }
        return footballersList;
    }

    private int checkNames(List<Footballer> footballersList, int counter, Footballer footballer) {
        for(Footballer footballer2 : footballersList){
            if(footballer != footballer2 && footballer.getNameSurname().equals(footballer2.getNameSurname())){
                counter += 1;
            }
            if(counter > 1){
                footballer2.setNameSurname(apiGateway.createNames());
                counter -= 1;
            }
        }
        return counter;
    }
}
