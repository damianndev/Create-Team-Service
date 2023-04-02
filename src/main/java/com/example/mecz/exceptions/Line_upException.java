package com.example.mecz.exceptions;

import java.text.MessageFormat;

public class Line_upException extends RuntimeException {

    public Line_upException(Integer lineupNumber){
        super(MessageFormat.format("The given line-up number {0} has not been created ", lineupNumber));
    }
}
