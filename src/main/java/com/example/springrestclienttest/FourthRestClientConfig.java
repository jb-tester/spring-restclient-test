package com.example.springrestclienttest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class FourthRestClientConfig {

    @Bean
    public FourthClientHttpExchangeInterface fifthClient() {

        RestClient client = RestClient.builder().baseUrl("http://localhost:8080/fourth").build();

        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();

        return proxyFactory.createClient(FourthClientHttpExchangeInterface.class);
    }
}
