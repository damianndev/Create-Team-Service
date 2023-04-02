package com.example.mecz.exceptions;

public class GoalkeeperException extends RuntimeException{

    public GoalkeeperException(){

        super("To create a team a goalkeeper is needed");
    }
}
