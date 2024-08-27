package com.LearnSpring.rest.webservices.restful_web_services.HelloWorld;

//

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// REST API
@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world") // Giving URL to REST API
    // Using this instead of above line will remove mentioning of method, similarly there is Post mapping for POST requests
    public String helloWorld() {
        return "Hello World"; // Returning Hello World String for Sample purposes instead of JSON that a REST API gives out
    }


    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello in JSON"); // Returning Hello World Bean instead of a string
        // This will return the bean as a JSON response

    }

    // Path Parameters -- Nothing but Variable names in our URL
    // /users/{id}/todos/{id}  => /users/2/todos/200
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/Vamsi

    @GetMapping(path = "/hello-world/path-variable/{name}") // USing the name from URL to display that in API output
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }



}
