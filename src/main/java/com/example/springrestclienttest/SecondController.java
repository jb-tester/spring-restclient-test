package com.example.springrestclienttest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/test0")
    public String test0() {
        return "second test0";
    }

    @GetMapping("/test1")
    public String test1() {
        return "second test1";
    }

    @GetMapping("/test2/{pvar}")
    public String test2(@PathVariable String pvar) {
        return "second test2 with "+pvar;
    }

    @PostMapping("/test3")
    public String test3(@RequestBody Pojo1 pojo){
        return "second test3: posted "+ pojo;
    }

    @GetMapping("/test4")
    public String test4() {
        return "second test4";
    }

    @GetMapping("/test5")
    public String test5() {
        return "first test5";
    }

}
