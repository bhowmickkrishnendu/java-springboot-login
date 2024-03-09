package com.krishgetapi.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public String getRootMessage() {
        return "ROOT API";
    }

    @GetMapping("/checkResponse")
    public String getCheckResponseMessage() {
        return "It's Perfectly Working!";
    }

    @GetMapping("/checkInternet")
    public ResponseEntity<byte[]> getCheckInternet() {
        ResponseEntity<byte[]> response = restTemplate.getForEntity("https://media.tenor.com/o2rlJc1PoLMAAAAi/dancin-monkey.gif", byte[].class);
    return response;
    }
}
