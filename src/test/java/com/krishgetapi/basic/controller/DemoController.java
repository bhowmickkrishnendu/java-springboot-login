package com.krishgetapi.basic.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    @GetMapping("/")
    public String getRootMessage() {
        return "ROOT API";
    }

    @GetMapping("/checkResponse")
    public String getCheckResponseMessage() {
        return "It's Perfectly Working!";
    }
    
    
}
