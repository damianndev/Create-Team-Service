package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class TrenerException extends RuntimeException{

    public TrenerException(String typTrenera, String errorMessage){
        super(MessageFormat.format("Trener {0} nie został stworzony, z powodu: {1}", typTrenera, errorMessage ));
    }
}
