package com.example.mecz.service;

import com.example.mecz.Utils.Utils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class NameSurnameService {

    public String createNameAndSurname(){
        List<String> listOfNames = prepareListOfNames();
        List<String> listOfSurnames = prepareListOfSurnames();
        String fullName = prepareName(listOfNames) + " " + prepareSurname(listOfSurnames);
        return fullName;
    }

    private String prepareName(List<String> listOfNames) {
       return listOfNames.get(Utils.draw(0,listOfNames.size()-1));
    }

    private   String prepareSurname(List<String> listOfSurnames) {
        return listOfSurnames.get(Utils.draw(0,listOfSurnames.size()-1));
    }

    private List<String> prepareListOfNames() {

        List<String> listOfNames = new ArrayList<>();

        listOfNames.add("Jake");
        listOfNames.add("Jack");
        listOfNames.add("Harry");
        listOfNames.add("Jacob");
        listOfNames.add("George");
        listOfNames.add("James");
        listOfNames.add("William");
        listOfNames.add("Connor");
        listOfNames.add("Liam");
        listOfNames.add("Ethan");
        listOfNames.add("Richard");
        listOfNames.add("Michael");
        listOfNames.add("Justin");
        listOfNames.add("Parker");
        listOfNames.add("Matt");
        listOfNames.add("Luke");
        listOfNames.add("Neil");
        listOfNames.add("Martin");
        listOfNames.add("Paul");
        listOfNames.add("John");
        listOfNames.add("Peter");

        return listOfNames;
    }

    private List<String> prepareListOfSurnames() {

        List<String> listOfSurnames = new ArrayList<>();

        listOfSurnames.add("Smith ");
        listOfSurnames.add("Jones");
        listOfSurnames.add("Williams");
        listOfSurnames.add("Taylor");
        listOfSurnames.add("Davies");
        listOfSurnames.add("Evans");
        listOfSurnames.add("Thomas");
        listOfSurnames.add("Johnson");
        listOfSurnames.add("Roberts");
        listOfSurnames.add("Walker");
        listOfSurnames.add("Wright");
        listOfSurnames.add("Robinson");
        listOfSurnames.add("Thompson");
        listOfSurnames.add("White");
        listOfSurnames.add("Hughes");
        listOfSurnames.add("Edwards");
        listOfSurnames.add("Green");
        listOfSurnames.add("Lewis");
        listOfSurnames.add("Wood");
        listOfSurnames.add("Jackson");
        listOfSurnames.add("Clarke");

        return listOfSurnames;

    }
}