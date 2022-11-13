package com.example.mecz.exceptions;

public class BramkarzException extends RuntimeException{

    public BramkarzException(){
        super("Do stworzenia drużyny potrzebny jest bramkarz");
    }
}
