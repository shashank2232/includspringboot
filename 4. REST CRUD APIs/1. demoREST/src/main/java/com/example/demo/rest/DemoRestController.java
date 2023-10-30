package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    // code for "/hello" endpoint
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    // in postman we send get request at localhost:8080/test/hello , we get Hello World with status code 200ok
}
