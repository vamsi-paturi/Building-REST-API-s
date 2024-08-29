package com.LearnSpring.rest.webservices.restful_web_services.User;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message); // Passing tio super class which is runtime exception
    }
}
