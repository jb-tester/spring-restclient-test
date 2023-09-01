package com.example.springrestclienttest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/test1")
    public String test1() {
        return "first test1";
    }

    @GetMapping("/test2/{pvar}")
    public String test2(@PathVariable String pvar) {
        return "first test2 with "+pvar;
    }

    @PostMapping("/test3")
    public String test3(@RequestBody Pojo1 pojo){
        return "first test3: posted "+ pojo;
    }

    @RequestMapping("/test4")
    public String test4(@RequestBody Pojo1 pojo) {
        return "first test4: posted \"+ pojo";
    }


}
