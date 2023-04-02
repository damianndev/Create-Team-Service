package com.example.mecz.controller;

import com.example.mecz.exceptions.Line_upException;
import com.example.mecz.model.Team;
import com.example.mecz.model.Line_Up;
import com.example.mecz.model.trener.coachType;
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
    public Team createTeam(@RequestBody TeamRequest teamRequest) {
        Team team = drużynaSerwis.stwórzDrużynę(teamRequest.getTypTrenera(), teamRequest.getNrUstawienia());
        return team;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/create-team-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team createTeamParams(@RequestParam("typTrenera") String typTrenera, @RequestParam("nrUstawienia") Integer nrUstawienia){
        Team team = drużynaSerwis.stwórzDrużynę(typTrenera, nrUstawienia);

        return team;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineup/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Line_Up giveMeLineUp(@PathVariable(value = "number") int number) {
        try {
            return drużynaSerwis.mapToLineup(number);
        } catch (Exception e) {
            throw new Line_upException(number);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCoaches(){
       return Arrays.asList(coachType.values()).stream()
               .map(typTrenera -> typTrenera.name()) //.map(Enum::name)
               .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getLineups(){
        return Arrays.asList(Line_Up.values()).stream()
                .map(lineUp -> lineUp.getNrUstawienia()) //.map(Ustawienie::getNrUstawienia)
                .collect(Collectors.toList());
    }

//TODO: w ramach ćwiczeń porobić kontrolery
}


