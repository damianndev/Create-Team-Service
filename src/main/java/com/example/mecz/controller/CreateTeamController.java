package com.example.mecz.controller;

import com.example.mecz.exceptions.UstawienieException;
import com.example.mecz.model.Drużyna;
import com.example.mecz.model.Ustawienie;
import com.example.mecz.model.trener.TypTrenera;
import com.example.mecz.service.DrużynaSerwis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CreateTeamController {

    private final DrużynaSerwis drużynaSerwis;

    @RequestMapping(method = RequestMethod.POST, path = "/create-team", produces = MediaType.APPLICATION_JSON_VALUE)
    public Drużyna createTeam(@RequestBody TeamRequest teamRequest) {
        Drużyna drużyna = drużynaSerwis.stwórzDrużynę(teamRequest.getTypTrenera(), teamRequest.getNrUstawienia());
        return drużyna;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/create-team-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Drużyna createTeamParams(@RequestParam("typTrenera") String typTrenera,@RequestParam("nrUstawienia") Integer nrUstawienia){
        Drużyna drużyna = drużynaSerwis.stwórzDrużynę(typTrenera, nrUstawienia);

        return drużyna;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineup", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ustawienie giveMeLineUp(@RequestParam(value = "number") int number) {
        try {
            return drużynaSerwis.mapToLineup(number);
        } catch (Exception e) {
            throw new UstawienieException(number);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCoaches(){
       return Arrays.asList(TypTrenera.values()).stream()
               .map(typTrenera -> typTrenera.name()) //.map(Enum::name)
               .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getLineups(){
        return Arrays.asList(Ustawienie.values()).stream()
                .map(ustawienie -> ustawienie.getNrUstawienia()) //.map(Ustawienie::getNrUstawienia)
                .collect(Collectors.toList());
    }


}


