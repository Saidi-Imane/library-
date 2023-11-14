package com.example.biblio.exeption.Handler;

import com.example.biblio.Shared.ErrorMessage;
import com.example.biblio.exeption.EntityAlreadyExistsExeption;
import com.example.biblio.exeption.EntityNotFoundExeption;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExeptionHandler {
    @ExceptionHandler(value = {EntityNotFoundExeption.class})
    public ResponseEntity<Object> entityNotFoundExeption(EntityNotFoundExeption ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message(ex.getMessage())
                .timeStamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> entityAlredyExistsExeption(MethodArgumentNotValidException ex){
        Map<String ,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
        return new ResponseEntity<>(errors,new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(value = {EntityAlreadyExistsExeption.class})
    public ResponseEntity<Object> entityAlredyExistsExeption(EntityAlreadyExistsExeption ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message(ex.getMessage())
                .timeStamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

}
