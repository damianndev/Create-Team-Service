package com.example.mecz.controller;

import com.example.mecz.model.Drużyna;
import com.example.mecz.service.DrużynaSerwis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final DrużynaSerwis drużynaSerwis;


    @RequestMapping(method = RequestMethod.POST, path = "/create-team", produces = MediaType.APPLICATION_JSON_VALUE)
    public Drużyna createTeam(@RequestBody TeamRequest teamRequest) {
        Drużyna drużyna = drużynaSerwis.stwórzDrużynę(teamRequest.getTypTrenera(), teamRequest.getNrUstawienia());
        return drużyna;
    }
}
//TODO: stwórz mapping ale get nie post używając request param (tak jak w wyścigu)