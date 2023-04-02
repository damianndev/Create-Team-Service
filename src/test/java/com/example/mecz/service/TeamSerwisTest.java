package com.example.mecz.service;
import com.example.mecz.CreateTeamServiceApplication;
import com.example.mecz.model.Team;
import com.example.mecz.model.piłkarz.Footballer;
import com.example.mecz.model.piłkarz.FootballerPosition;
import com.example.mecz.model.trener.coachType;
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


class TeamSerwisTest {


    @ParameterizedTest
    //@ValueSource(ints = {1,2,3,4,5,6})
    //@CsvSource({"DEFENSIVE,4", "OFFENSIVE,1"})
    //@CsvFileSource(resources = "/createTeam.csv", numLinesToSkip = 1)
    @MethodSource("prepareCasesForCreatingTeam")
    public void powinnoStworzyćDrużynę(String typTrenera, int nrUstawienia) {
        //given
        coachType coachTypeEnum = coachType.valueOf(typTrenera);
        ApiGateway apiGateway = new ApiGateway();
        ImieNazwiskoSerwis imieNazwiskoSerwis = new ImieNazwiskoSerwis();
        PiłkarzSerwis piłkarzSerwis = new PiłkarzSerwis(imieNazwiskoSerwis,apiGateway);
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        DrużynaSerwis drużynaSerwis = new DrużynaSerwis(piłkarzSerwis,trenerSerwis,apiGateway);
        //when
        Team team = drużynaSerwis.stwórzDrużynę(typTrenera,nrUstawienia);
        //then
        Assertions.assertEquals(team.getLineUp().getNrUstawienia(),nrUstawienia);
        Assertions.assertTrue(team.getFootballers().size() > 22);
        Assertions.assertEquals(team.getCoach().getCoachType(), coachTypeEnum);
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
        List<Footballer> footballerList = new ArrayList<>();

        footballerList.add(piłkarzSerwis.stwórzPiłkarza(FootballerPosition.DEFENDER));
        footballerList.add(piłkarzSerwis.stwórzPiłkarza(FootballerPosition.DEFENDER));
        footballerList.add(piłkarzSerwis.stwórzPiłkarza(FootballerPosition.DEFENDER));
        checkNames(footballerList);


        String imieNazwisko = footballerList.get(1).getNameSurname();
        footballerList.size();
    }
    private List<Footballer> checkNames (List<Footballer> listaPiłkarzy){
        ApiGateway apiGateway = new ApiGateway();
        int licznik = 1;
        for (Footballer footballer1 : listaPiłkarzy) {
            for(Footballer footballer2 : listaPiłkarzy){
                if(footballer1 != footballer2 && footballer1.getNameSurname().equals(footballer2.getNameSurname())){
                    licznik += 1;
                }
                if(licznik > 1){
                    footballer2.setNameSurname(apiGateway.createNames());
                    licznik -= 1;
                }
            }
        }
        return listaPiłkarzy;
    }
}


