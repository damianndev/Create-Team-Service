package com.example.mecz.service;

import com.example.mecz.model.trener.Coach;
import com.example.mecz.model.trener.coachType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class CoachSerwisTest {


    @Test
    public void powinnoStworzyćTrenera() {
        //given
        ApiGateway apiGateway = new ApiGateway();
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        coachType coachType = coachType.DEFENSIVE;
        //when
        Coach coach = trenerSerwis.stwórzTrenera(coachType);
        //then
        Assertions.assertNotNull(coach);
        Assertions.assertEquals(coachType.DEFENSIVE, coach.getCoachType());
    }

    @Test
    public void powinnoRzucicWyjątek(){
        //given
        ApiGateway apiGateway = new ApiGateway();
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        //then
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            trenerSerwis.stwórzTrenera(coachType.valueOf("INTERN"));
        });
        Assertions.assertEquals("Unexpected value: INTERN", exception.getMessage());
    }
}

