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
public class DrużynaSerwis {

    private static final Integer DODATKOWY_BRAMKARZ = 2;
    private static final Integer DODATKOWY_OBROŃCA = 4;
    private static final Integer DODATKOWY_DEFENSYWNY_POMOCNIK = 2;
    private static final Integer DODATKOWY_POMOCNIK = 4;
    private static final Integer DODATKOWY_OFENSYWNY_POMOCNIK = 2;
    private static final Integer DODATKOWY_NAPASTNIK = 2;

    private PiłkarzSerwis piłkarzSerwis;
    private TrenerSerwis trenerSerwis;
    private ApiGateway apiGateway;


    public DrużynaSerwis(PiłkarzSerwis piłkarzSerwis, TrenerSerwis trenerSerwis, ApiGateway apiGateway) {
        this.piłkarzSerwis = piłkarzSerwis;
        this.trenerSerwis = trenerSerwis;
        this.apiGateway = apiGateway;
    }

    public Team stwórzDrużynę(String typTrenera, Integer nrUstawienia) {
        Line_Up lineUp = mapToLineup(nrUstawienia);
        List<Footballer> piłkarze = stworzeniePiłkarzy(lineUp);
        Coach coach = stwórzTrenera(typTrenera);
        return new Team(lineUp, piłkarze, coach);
    }

    public Coach stwórzTrenera(String typTrenera) {
        try {
            Coach coach = trenerSerwis.stwórzTrenera(coachType.valueOf(typTrenera));
            return coach;
        } catch (Exception exception) {
            throw new CoachException(typTrenera, exception.getMessage());
        }
    }

    public Line_Up mapToLineup(Integer nrUstawienia) {
        List<Line_Up> lineups = new ArrayList<>(Arrays.asList(Line_Up.values()));
        Line_Up lineUp = lineups.stream()
                .filter(l -> l.getNrUstawienia().equals(nrUstawienia))
                .findFirst()
                .orElseThrow(() -> new Line_upException(nrUstawienia));
        return lineUp;
    }

    private List<Footballer> stworzeniePiłkarzy(Line_Up lineUp) {
        Integer ilośćBramkarzy = lineUp.getBramkarz();
        Integer ilośćObrońców = lineUp.getLiczbaObrońców();
        Integer ilośćDefensywnychPomocników = lineUp.getLiczbaDefensywnychPomocników();
        Integer ilośćPomocników = lineUp.getLiczbaPomocników();
        Integer ilośćOfensywnychPomocników = lineUp.getLiczbaOfensywnychPomocników();
        Integer ilośćNapastników = lineUp.getLiczbaNapastników();

        List<Footballer> listaPiłkarzy = new ArrayList<>();

        if (ilośćBramkarzy > 0) {
            for (int i = 0; i < ilośćBramkarzy + DODATKOWY_BRAMKARZ; i++) {
                Footballer bramkarz = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.GOALKEEPER);
                listaPiłkarzy.add(bramkarz);
            }
        } else {
            throw new GoalkeeperException();
        }
        if (ilośćObrońców > 0) {
            for (int i = 0; i < ilośćObrońców + DODATKOWY_OBROŃCA; i++) {
                Footballer obrońca = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.DEFENDER);
                listaPiłkarzy.add(obrońca);
            }
        }
        if (ilośćDefensywnychPomocników > 0) {
            for (int i = 0; i < ilośćDefensywnychPomocników + DODATKOWY_DEFENSYWNY_POMOCNIK; i++) {
                Footballer defensywnyPomocnik = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.DEFENSIVE_MIDFIELDER);
                listaPiłkarzy.add(defensywnyPomocnik);
            }
        }
        if (ilośćPomocników > 0) {
            for (int i = 0; i < ilośćPomocników + DODATKOWY_POMOCNIK; i++) {
                Footballer pomocnik = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.FORWARD_MIDFIELDER);
                listaPiłkarzy.add(pomocnik);
            }
        }
        if (ilośćOfensywnychPomocników > 0) {
            for (int i = 0; i < ilośćOfensywnychPomocników + DODATKOWY_OFENSYWNY_POMOCNIK; i++) {
                Footballer ofensywnyPomocnik = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.OFFENSIVE_MIDFIELDER);
                listaPiłkarzy.add(ofensywnyPomocnik);
            }
        }
        if (ilośćNapastników > 0) {
            for (int i = 0; i < ilośćNapastników + DODATKOWY_NAPASTNIK; i++) {
                Footballer napastnik = piłkarzSerwis.stwórzPiłkarza(FootballerPosition.STRIKER);
                listaPiłkarzy.add(napastnik);
            }
        }

        return filterNames(listaPiłkarzy);

    }

    private List<Footballer> filterNames (List<Footballer> listaPiłkarzy){
        int licznik = 1;
        for (Footballer footballer : listaPiłkarzy) {
            licznik = checkNames(listaPiłkarzy, licznik, footballer);
        }
        return listaPiłkarzy;
    }

    private int checkNames(List<Footballer> listaPiłkarzy, int licznik, Footballer footballer) {
        for(Footballer footballer2 : listaPiłkarzy){
            if(footballer != footballer2 && footballer.getNameSurname().equals(footballer2.getNameSurname())){
                licznik += 1;
            }
            if(licznik > 1){
                footballer2.setNameSurname(apiGateway.createNames());
                licznik -= 1;
            }
        }
        return licznik;
    }
}
