package com.example.mecz.service;
import com.example.mecz.CreateTeamServiceApplication;
import com.example.mecz.model.Drużyna;
import com.example.mecz.model.piłkarz.Piłkarz;
import com.example.mecz.model.piłkarz.PozycjaPiłkarza;
import com.example.mecz.model.trener.TypTrenera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CreateTeamServiceApplication.class)
//@RunWith(SpringRunner.class)


class DrużynaSerwisTest {


    @ParameterizedTest
    //@ValueSource(ints = {1,2,3,4,5,6})
    //@CsvSource({"DEFENSIVE,4", "OFFENSIVE,1"})
    //@CsvFileSource(resources = "/createTeam.csv", numLinesToSkip = 1)
    @MethodSource("prepareCasesForCreatingTeam")
    public void powinnoStworzyćDrużynę(String typTrenera, int nrUstawienia) {
        //given
        TypTrenera typTreneraEnum = TypTrenera.valueOf(typTrenera);
        ApiGateway apiGateway = new ApiGateway();
        ImieNazwiskoSerwis imieNazwiskoSerwis = new ImieNazwiskoSerwis();
        PiłkarzSerwis piłkarzSerwis = new PiłkarzSerwis(imieNazwiskoSerwis,apiGateway);
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        DrużynaSerwis drużynaSerwis = new DrużynaSerwis(piłkarzSerwis,trenerSerwis,apiGateway);
        //when
        Drużyna drużyna = drużynaSerwis.stwórzDrużynę(typTrenera,nrUstawienia);
        //then
        Assertions.assertEquals(drużyna.getUstawienie().getNrUstawienia(),nrUstawienia);
        Assertions.assertTrue(drużyna.getPiłkarze().size() > 22);
        Assertions.assertEquals(drużyna.getTrener().getTypTrenera(),typTreneraEnum);
    }

    private static Stream<Arguments> prepareCasesForCreatingTeam(){
        return Stream.of(
                Arguments.of("DEFENSIVE",4),
                Arguments.of("OFFENSIVE",1)
        );
    }



    @Test
    public void powinnoZmienićNazwę() {

        ImieNazwiskoSerwis imieNazwiskoSerwis = new ImieNazwiskoSerwis();
        ApiGateway apiGateway = new ApiGateway();
        PiłkarzSerwis piłkarzSerwis = new PiłkarzSerwis(imieNazwiskoSerwis,apiGateway);
        List<Piłkarz> piłkarzList = new ArrayList<>();

        piłkarzList.add(piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.OBROŃCA));
        piłkarzList.add(piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.OBROŃCA));
        piłkarzList.add(piłkarzSerwis.stwórzPiłkarza(PozycjaPiłkarza.OBROŃCA));
        checkNames(piłkarzList);


        String imieNazwisko = piłkarzList.get(1).getImieNazwisko();
        piłkarzList.size();
    }
    private List<Piłkarz> checkNames (List<Piłkarz> listaPiłkarzy){
        ApiGateway apiGateway = new ApiGateway();
        int licznik = 1;
        for (Piłkarz piłkarz1: listaPiłkarzy) {
            for(Piłkarz piłkarz2: listaPiłkarzy){
                if(piłkarz1 != piłkarz2 && piłkarz1.getImieNazwisko().equals(piłkarz2.getImieNazwisko())){
                    licznik += 1;
                }
                if(licznik > 1){
                    piłkarz2.setImieNazwisko(apiGateway.createNames());
                    licznik -= 1;
                }
            }
        }
        return listaPiłkarzy;
    }
}


