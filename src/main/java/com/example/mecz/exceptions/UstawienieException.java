package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class UstawienieException extends RuntimeException {

    public UstawienieException(Integer nrUstawienia){
        super(MessageFormat.format("Podany nr ustawienia {0} nie został stworzony ", nrUstawienia));
    }
}
