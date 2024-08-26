package com.LearnSpring.rest.webservices.restful_web_services;

//

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// REST API
@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }

}
