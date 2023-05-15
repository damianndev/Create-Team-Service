package com.example.mecz.service;

import com.example.mecz.model.coach.Coach;
import com.example.mecz.model.coach.CoachType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoachServiceTest {


    @Test
    public void shouldCreateCoach() {
        //given
        ApiGateway apiGateway = new ApiGateway();
        CoachService coachService = new CoachService(apiGateway);
        CoachType coachType = CoachType.DEFENSIVE;
        //when
        Coach coach = coachService.createCoach(coachType);
        //then
        Assertions.assertNotNull(coach);
        Assertions.assertEquals(CoachType.DEFENSIVE, coach.getCoachType());
    }

    @Test
    public void shouldThrowException(){
        //given
        ApiGateway apiGateway = new ApiGateway();
        CoachService coachService = new CoachService(apiGateway);
        //then
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            coachService.createCoach(CoachType.valueOf("INTERN"));
        });
        Assertions.assertEquals("Unexpected value: INTERN", exception.getMessage());
    }
}

