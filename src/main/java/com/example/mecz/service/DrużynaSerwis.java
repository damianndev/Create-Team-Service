package com.example.mecz.service;

import com.example.mecz.exceptions.BramkarzException;
import com.example.mecz.exceptions.TrenerException;
import com.example.mecz.exceptions.UstawienieException;
import com.example.mecz.model.Drużyna;
import com.example.mecz.model.Ustawienie;
import com.example.mecz.model.piłkarz.Piłkarz;
import com.example.mecz.model.piłkarz.PozycjaPiłkarza;
import com.example.mecz.model.trener.Trener;
import com.example.mecz.model.trener.TypTrenera;
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

    public Drużyna stwórzDrużynę(String typTrenera, Integer nrUstawienia) {
        Ustawienie ustawienie = mapToLineup(nrUstawienia);
        List<Piłkarz> piłkarze = stworzeniePiłkarzy(ustawienie);
        Trener trener = stwórzTrenera(typTrenera);
        return new Drużyna(ustawienie, piłkarze, trener);
    }

    public Trener stwórzTrenera(String typTrenera) {
        try {
            Trener trener = trenerSerwis.stwórzTrenera(TypTrenera.valueOf(typTrenera));
            return trener;
        } catch (Exception exception) {
            throw new TrenerException(typTrenera, exception.getMessage());
        }
    }

    public Ustawienie mapToLineup(Integer nrUstawienia) {
        List<Ustawienie> lineups = new ArrayList<>(Arrays.asList(Ustawienie.values()));
        Ustawienie ustawienie = lineups.stream()
                .filter(l -> l.getNrUstawienia().equals(nrUstawienia))
                .findFirst()
                .orElseThrow(() -> new UstawienieException(nrUstawienia));
        return ustawienie;
    }

    private List<Piłkarz> stworzeniePiłkarzy(Ustawienie ustawienie) {
        Integer ilośćBramkarzy = ustawienie.getBramkarz();
        Integer ilośćObrońców = ustawienie.getLiczbaObrońców();
        Integer ilośćDefensywnychPomocników = ustawienie.getLiczbaDefensywnychPomocników();
        Integer ilośćPomocników = ustawienie.getLiczbaPomocników();
        Integer ilośćOfensywnychPomocników = ustawienie.getLiczbaOfensywnychPomocników();
        Integer ilośćNapastników = ustawienie.getLiczbaNapastników();

        List<Piłkarz> listaPiłkarzy = new ArrayList<>();

        if (ilośćBramkarzy > 0) {
            for (int i = 0; i < ilośćBramkarzy + DODATKOWY_BRAMKARZ; i++) {
                Piłkarz bramkarz = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.BRAMKARZ);
                listaPiłkarzy.add(bramkarz);
            }
        } else {
            throw new BramkarzException();
        }
        if (ilośćObrońców > 0) {
            for (int i = 0; i < ilośćObrońców + DODATKOWY_OBROŃCA; i++) {
                Piłkarz obrońca = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.OBROŃCA);
                listaPiłkarzy.add(obrońca);
            }
        }
        if (ilośćDefensywnychPomocników > 0) {
            for (int i = 0; i < ilośćDefensywnychPomocników + DODATKOWY_DEFENSYWNY_POMOCNIK; i++) {
                Piłkarz defensywnyPomocnik = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.DEFENSYWNY_POMOCNIK);
                listaPiłkarzy.add(defensywnyPomocnik);
            }
        }
        if (ilośćPomocników > 0) {
            for (int i = 0; i < ilośćPomocników + DODATKOWY_POMOCNIK; i++) {
                Piłkarz pomocnik = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.POMOCNIK);
                listaPiłkarzy.add(pomocnik);
            }
        }
        if (ilośćOfensywnychPomocników > 0) {
            for (int i = 0; i < ilośćOfensywnychPomocników + DODATKOWY_OFENSYWNY_POMOCNIK; i++) {
                Piłkarz ofensywnyPomocnik = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.OFENSYWNY_POMOCNIK);
                listaPiłkarzy.add(ofensywnyPomocnik);
            }
        }
        if (ilośćNapastników > 0) {
            for (int i = 0; i < ilośćNapastników + DODATKOWY_NAPASTNIK; i++) {
                Piłkarz napastnik = piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.NAPASTNIK);
                listaPiłkarzy.add(napastnik);
            }
        }

        return filterNames(listaPiłkarzy);

    }

    private List<Piłkarz> filterNames (List<Piłkarz> listaPiłkarzy){
        int licznik = 1;
        for (Piłkarz piłkarz: listaPiłkarzy) {
            licznik = checkNames(listaPiłkarzy, licznik, piłkarz);
        }
        return listaPiłkarzy;
    }

    private int checkNames(List<Piłkarz> listaPiłkarzy, int licznik, Piłkarz piłkarz) {
        for(Piłkarz piłkarz2: listaPiłkarzy){
            if(piłkarz != piłkarz2 && piłkarz.getImieNazwisko().equals(piłkarz2.getImieNazwisko())){
                licznik += 1;
            }
            if(licznik > 1){
                piłkarz2.setImieNazwisko(apiGateway.createNames());
                licznik -= 1;
            }
        }
        return licznik;
    }
}
