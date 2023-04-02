package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class FootballerException extends RuntimeException{

    public FootballerException(String footballerPosition, String errorMessage){
        super(MessageFormat.format("Footballer {0} was not created, due to: {1}", footballerPosition, errorMessage ));
    }
}
