package com.LearnSpring.rest.webservices.restful_web_services.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
public class UserResource {
    private UserDaoService service;


    public UserResource(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/users")
    public List<User> retreiveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public  User retreiveUserID(@PathVariable int id){
        return service.findUser(id);
    }





//    @GetMapping(path = "/hello-world/path-variable/{name}") // USing the name from URL to display that in API output
//    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//        return new HelloWorldBean(String.format("Hello World, %s", name));
//    }





}
