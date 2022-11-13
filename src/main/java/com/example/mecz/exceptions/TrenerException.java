package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class TrenerException extends RuntimeException{

    public TrenerException(String typTrenera){
        super(MessageFormat.format("Trener {0} nie został stworzony ", typTrenera));
    }
}
