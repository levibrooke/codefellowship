package com.levibrooke.codefellowship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CodeFellowshipController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/sign-up")
    public String getSignUp() {
        return "sign-up";
    }
}
