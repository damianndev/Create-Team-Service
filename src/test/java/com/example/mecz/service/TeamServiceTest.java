package com.example.mecz.service;

import com.example.mecz.CreateTeamServiceApplication;
import com.example.mecz.model.Team;
import com.example.mecz.model.footballer.Footballer;
import com.example.mecz.model.footballer.FootballerPosition;
import com.example.mecz.model.coach.CoachType;
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


class TeamServiceTest {

    @ParameterizedTest
    //@ValueSource(ints = {1,2,3,4,5,6})
    //@CsvSource({"DEFENSIVE,4", "OFFENSIVE,1"})
    //@CsvFileSource(resources = "/createTeam.csv", numLinesToSkip = 1)
    @MethodSource("prepareCasesForCreatingTeam")
    public void shouldCreateTeam(String typTrenera, int nrUstawienia) {
        //given
        CoachType coachTypeEnum = CoachType.valueOf(typTrenera);
        ApiGateway apiGateway = new ApiGateway();
        NameSurnameService imieNazwiskoSerwis = new NameSurnameService();
        FootballerService piłkarzSerwis = new FootballerService(imieNazwiskoSerwis,apiGateway);
        CoachService trenerSerwis = new CoachService(apiGateway);
        TeamService drużynaSerwis = new TeamService(piłkarzSerwis,trenerSerwis,apiGateway);
        //when
        Team team = drużynaSerwis.createTeam(typTrenera,nrUstawienia);
        //then
        Assertions.assertEquals(team.getLineUp().getLineupNumber(),nrUstawienia);
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
    public void shouldChangeName() {

        NameSurnameService nameSurnameService = new NameSurnameService();
        ApiGateway apiGateway = new ApiGateway();
        FootballerService footballerService = new FootballerService(nameSurnameService,apiGateway);
        List<Footballer> footballerList = new ArrayList<>();

        footballerList.add(footballerService.createFootballer(FootballerPosition.DEFENDER));
        footballerList.add(footballerService.createFootballer(FootballerPosition.DEFENDER));
        footballerList.add(footballerService.createFootballer(FootballerPosition.DEFENDER));
        checkNames(footballerList);

        String nameSurname = footballerList.get(1).getNameSurname();
        footballerList.size();
    }

    private List<Footballer> checkNames (List<Footballer> footballersList){
        ApiGateway apiGateway = new ApiGateway();
        int counter = 1;
        for (Footballer footballer1 : footballersList) {
            for(Footballer footballer2 : footballersList){
                if(footballer1 != footballer2 && footballer1.getNameSurname().equals(footballer2.getNameSurname())){
                    counter += 1;
                }
                if(counter > 1){
                    footballer2.setNameSurname(apiGateway.createNames());
                    counter -= 1;
                }
            }
        }
        return footballersList;
    }
}


