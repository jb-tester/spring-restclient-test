package com.example.springrestclienttest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.springframework.http.MediaType.APPLICATION_JSON;

// use uriBuilderFactory
@Service
public class ThirdRestClientService {

   
    final String BASEURL = "http://localhost:8080/third";
    
    // baseUrl as local var
    public void test1(){
        String baseUrl = "http://localhost:8080/third";
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        RestClient client = RestClient.builder().uriBuilderFactory(factory).build();
        String result = client.get()
                .uri("/test1") // no base part in Endpoints
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /third/test1: \n it returns \"" + result + "\"");

    }
    // baseUrl as constant
    public void test2(){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASEURL);
        RestClient client = RestClient.builder().uriBuilderFactory(factory).build();

        String result = client.get()
                .uri("/test2/{pv}", "foo") // no base part in Endpoints
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /third/test2: \n it returns \"" + result + "\"");

    }
    // baseUrl inlined
    public void test3(){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://localhost:8080/third");
        RestClient client = RestClient.builder().uriBuilderFactory(factory).build();
        Pojo1 pojo  = new Pojo1("aaa","bbb");
        String response = client.post()
                .uri("/test3") // no base part in Endpoints
                .contentType(APPLICATION_JSON)
                .body(pojo)
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /third/test3: \n it returns \"" + response + "\"");
    }
}
