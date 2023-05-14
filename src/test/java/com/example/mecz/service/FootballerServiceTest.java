package com.example.mecz.service;

import com.example.mecz.model.footballer.Footballer;
import com.example.mecz.model.footballer.FootballerPosition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FootballerServiceTest {

    @Test
    public void shouldCreateFootballer() {
        //given
        NameSurnameService nameSurnameService = new NameSurnameService();
        ApiGateway apiGateway = new ApiGateway();
        FootballerService footballerService = new FootballerService(nameSurnameService, apiGateway);
        //when
        Footballer footballer = footballerService.createFootballer(FootballerPosition.MIDFIELDER);
        //then
        Assert.assertNotNull(footballer);
        Assert.assertEquals(FootballerPosition.MIDFIELDER, footballer.getFootballerPositions().get(0));
        Assert.assertEquals(FootballerPosition.OFFENSIVE_MIDFIELDER, footballer.getFootballerPositions().get(1));
    }
}