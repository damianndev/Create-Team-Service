package com.example.mecz.service;


import com.example.mecz.model.trener.*;
import org.springframework.stereotype.Service;

@Service
public class TrenerSerwis {

    public Trener stwórzTrenera(TypTrenera typTrenera) {
        Trener trener;

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


        return trener;
    }
}