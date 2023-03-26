package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class PiłkarzException extends RuntimeException{

    public PiłkarzException(String pozycjaPiłkarza, String errorMessage){
        super(MessageFormat.format("Piłkarz {0} nie został stworzony, z powodu: {1}", pozycjaPiłkarza, errorMessage ));
    }
}
