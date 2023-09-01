package com.example.springrestclienttest;

import org.springframework.web.service.annotation.GetExchange;


public interface FourthClientHttpExchangeInterface {

    @GetExchange("/test1")
    String test1();
    @GetExchange("/test2") String test2();
}
