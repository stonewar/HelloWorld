package com.example.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yapi on 12.06.18.
 */

@RestController
@RequestMapping("/greetings")
public class GreetingResource {

    @GetMapping
    public String sayHello() {
        return "Hello from " + GreetingResource.class.getName()+" 6th version";
    }
}
