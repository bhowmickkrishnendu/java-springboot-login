package com.krishgetapi.basic.controller;

// import com.krishgetapi.basic.model.User;
import com.krishgetapi.basic.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return ResponseEntity.ok("Login successful. Welcome " + existingUser.getFirstname() + " " + existingUser.getLastname());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
