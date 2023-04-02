package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class CoachException extends RuntimeException{

    public CoachException(String coachType, String errorMessage){
        super(MessageFormat.format("Coach {0} was not created, due to: {1}", coachType, errorMessage ));
    }
}
