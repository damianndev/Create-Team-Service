package com.example.mecz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ApiGateway {

    @RequestMapping(method = RequestMethod.GET, path = "/imie")
    public String createNames(){
        String url = "https://names.drycodes.com/1?nameOptions=boy_names";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        String body = entity.getBody();
        String zamiana = body.toString()
                .replace("_", " ")
                .replace("[", "")
                .replace("]", "");

        return zamiana;

    }
}

//TODO: dodatkowy replace bo przychodzą z apigateway nazwy z "/"