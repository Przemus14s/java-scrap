package com.example.scrap_app.handler;


import com.example.scrap_app.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException ex){
        Map<String, String> response = new HashMap<>();

        response.put("message", "Użytkownik o podanym ID nie istnieje");
        response.put("error", "User not found");
        response.put("code", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
