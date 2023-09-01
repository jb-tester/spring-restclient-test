package com.example.springrestclienttest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

// without baseURL
@Service
public class FirstRestClientService {

    public static final String URL = "http://localhost:8080/first/test3";

    // no base uri: uri as local variable
    public void test1(){
        RestClient client = RestClient.create();

        String test1Url = "http://localhost:8080/first/test1";
        String result = client.get()
                .uri(test1Url) // nothing in Endpoints
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test1: \n it returns \"" + result + "\"");

    }
    // no base uri: uri as string
    public void test2(){
        RestClient client = RestClient.create();

        String result = client.get()
                .uri("http://localhost:8080/first/test2/{pv}", "foo")
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test2: \n it returns \"" + result + "\"");

    }
    // no base uri: uri as constant
    public void test3(){
        RestClient client = RestClient.create();
        Pojo1 pojo  = new Pojo1("aaa","bbb");
        String response = client.post()
                .uri(URL)
                .contentType(APPLICATION_JSON)
                .body(pojo)
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test3: \n it returns \"" + response + "\"");
    }
    
    public void test4(){
        Pojo1 pojo  = new Pojo1("aaa","bbb");
        RestClient client = RestClient.create();
        String result = client.method(HttpMethod.POST)
                .uri("http://localhost:8080/first/test4")
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .body(pojo)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is4xxClientError()) {
                        return response.getStatusText()+response.getHeaders();
                    }
                    else {
                        return pojo.toString();
                    }
                });
        System.out.println("===== Trying /first/test4: \n it returns \"" + result + "\"");
    }
}
