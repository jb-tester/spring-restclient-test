package com.example.springrestclienttest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fourth")
public class FourthController {

    @GetMapping("/test1")
    public String test1() {
        return "fourth test1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "fourth test2";
    }
}
