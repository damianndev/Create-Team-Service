package com.example.mecz.service;

import com.example.mecz.model.trener.Trener;
import com.example.mecz.model.trener.TypTrenera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class TrenerSerwisTest {


    @Test
    public void powinnoStworzyćTrenera() {
        //given
        ApiGateway apiGateway = new ApiGateway();
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        TypTrenera typTrenera = TypTrenera.DEFENSIVE;
        //when
        Trener trener = trenerSerwis.stwórzTrenera(typTrenera);
        //then
        Assertions.assertNotNull(trener);
        Assertions.assertEquals(TypTrenera.DEFENSIVE, trener.getTypTrenera());
    }

    @Test
    public void powinnoRzucicWyjątek(){
        //given
        ApiGateway apiGateway = new ApiGateway();
        TrenerSerwis trenerSerwis = new TrenerSerwis(apiGateway);
        //then
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            trenerSerwis.stwórzTrenera(TypTrenera.valueOf("INTERN"));
        });
        Assertions.assertEquals("Unexpected value: INTERN", exception.getMessage());
    }
}

