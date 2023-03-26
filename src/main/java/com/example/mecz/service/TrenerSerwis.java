package com.example.mecz.service;


import com.example.mecz.exceptions.TrenerException;
import com.example.mecz.model.trener.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrenerSerwis {

    private ApiGateway apiGateway;

    public TrenerSerwis(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }


    public Trener stwórzTrenera(TypTrenera typTrenera) {
        Trener trener;

        try {
            switch (typTrenera) {
                case OFFENSIVE:
                    trener = new TrenerOfensywny();
                    break;
                case BALANCED:
                    trener = new TrenerZrównoważony();
                    break;
                case DEFENSIVE:
                    trener = new TrenerDefensywny();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + typTrenera);
            }

            createName(trener);
        } catch (Exception e) {
            //logowanie błędów + nie zjadanie ich
            log.error(String.format("Nie udało się stworzyć trenera, z powodu: %s", e.getMessage()), e);
            throw new TrenerException(typTrenera.name(), e.getMessage());
        }

        return trener;
    }



    private Trener createName(Trener trener) {
        try {
            String name = apiGateway.createNames();
            trener.setImieNazwisko(name);
        } catch (Exception exception) {
            trener.setImieNazwisko("Paulo Sousa");
        }
        return trener;
    }
}