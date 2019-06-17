package com.levibrooke.codefellowship;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeFellowshipController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
