package com.example.springrestclienttest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestclientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestclientTestApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(FirstRestClientService firstClient, SecondRestClientService secondClient, ThirdRestClientService thirdClient, FourthClientHttpExchangeInterface fourthClient) {
        return args -> {
            firstClient.test1();
            firstClient.test2();
            firstClient.test3();
            firstClient.test4();
            secondClient.test0();
            secondClient.test1();
            secondClient.test2();
            secondClient.test3();
            secondClient.test4();
            secondClient.test5();
            thirdClient.test1();
            thirdClient.test2();
            thirdClient.test3();
            System.out.println("===== Trying /fourth/test1: \n it returns \"" + fourthClient.test1() + "\"");
        };
    }
}
