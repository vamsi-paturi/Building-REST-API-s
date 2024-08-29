package com.LearnSpring.rest.webservices.restful_web_services.HelloWorld;

//

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


// REST API
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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


    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale(); // Utility method to get the user locale.
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );

        //return "Hello World V2";

        //1:
        //2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

    }




}
