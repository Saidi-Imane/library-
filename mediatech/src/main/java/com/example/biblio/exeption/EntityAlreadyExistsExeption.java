package com.example.biblio.exeption;

public class EntityAlreadyExistsExeption extends RuntimeException{
    public EntityAlreadyExistsExeption() {
    }

    public EntityAlreadyExistsExeption(String message) {
        super(message);
    }
}
