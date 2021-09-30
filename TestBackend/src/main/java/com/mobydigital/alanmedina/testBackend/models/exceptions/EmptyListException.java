package com.mobydigital.alanmedina.testBackend.models.exceptions;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String message){
        super(message);
    }
}
