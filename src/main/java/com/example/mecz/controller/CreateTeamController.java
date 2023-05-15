package com.example.mecz.controller;

import com.example.mecz.controller.dto.CoachDto;
import com.example.mecz.controller.dto.LineUpDto;
import com.example.mecz.exceptions.Line_upException;
import com.example.mecz.model.Team;
import com.example.mecz.model.Line_Up;
import com.example.mecz.model.coach.CoachType;
import com.example.mecz.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class CreateTeamController {

    private final TeamService teamService;

    @RequestMapping(method = RequestMethod.POST, path = "/create-team", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team createTeam(@RequestBody TeamRequest teamRequest) {
        Team team = teamService.createTeam(teamRequest.getCoachType(), teamRequest.getLineupNumber());
        return team;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/create-team-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team createTeamParams(@RequestParam("coachType") String coachType, @RequestParam("lineupNumber") Integer lineupNumber){
        Team team = teamService.createTeam(coachType, lineupNumber);
        return team;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineup/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Line_Up giveMeLineUp(@PathVariable(value = "number") int number) {
        try {
            return teamService.mapToLineup(number);
        } catch (Exception e) {
            throw new Line_upException(number);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CoachDto> getCoaches(){
       return Arrays.asList(CoachType.values()).stream()
               .map(coachType -> CoachDto.builder()
                       .coachType(coachType.name())
                       .build())
               .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lineups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LineUpDto> getLineups(){
        return Arrays.asList(Line_Up.values()).stream()
                //.map(ustawienie -> new LineUpDto(ustawienie.getNrUstawienia(), ustawienie.name())) //.map(Ustawienie::getNrUstawienia)
                .map(lineup -> LineUpDto.builder()
                        .lineupNumber(lineup.getLineupNumber())
                        .lineupName(lineup.name())
                        .build())
                .collect(Collectors.toList());
    }

}


