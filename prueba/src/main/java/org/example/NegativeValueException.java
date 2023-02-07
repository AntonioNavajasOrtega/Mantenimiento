package org.example;

public class NegativeValueException extends RuntimeException{
    public  NegativeValueException(String errorMessage)
    {
        super(errorMessage);
    }
}
