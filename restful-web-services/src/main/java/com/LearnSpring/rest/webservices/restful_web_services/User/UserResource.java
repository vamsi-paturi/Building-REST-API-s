package com.LearnSpring.rest.webservices.restful_web_services.User;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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
    public EntityModel<User> retreiveUserID(@PathVariable int id){

//        if(User==null)

        User user = service.findUser(id);

        if(user==null)
            throw new  UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user);

        // Instead of hard coding to adapt to changing codes
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retreiveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUSer(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        // users/4 => /users/{id},  user.getID

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri(); // Returning the Location of where the new post request created a user

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }





//    @GetMapping(path = "/hello-world/path-variable/{name}") // USing the name from URL to display that in API output
//    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//        return new HelloWorldBean(String.format("Hello World, %s", name));
//    }





}
