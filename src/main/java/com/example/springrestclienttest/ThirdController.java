package com.example.springrestclienttest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/third")
public class ThirdController {

    @GetMapping("/test1")
    public String test1() {
        return "third test1";
    }

    @GetMapping("/test2/{pvar}")
    public String test2(@PathVariable String pvar) {
        return "third test2 with "+pvar;
    }

    @PostMapping("/test3")
    public String test3(@RequestBody Pojo1 pojo){
        return "third test3: posted "+ pojo;
    }
}
