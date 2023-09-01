package com.example.springrestclienttest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

// with baseURL: .create(baseUri), .builder().baseUrl(baseUri)
@Service
public class SecondRestClientService {
    private static final String CONSTANT_URI = "/test4";
    final String BASEURL = "http://localhost:8080/second";

    // baseuri - local var, uri - inlined
    public void test0(){
        String baseuri = "http://localhost:8080/second";
        RestClient client = RestClient.create(baseuri);
        //RestClient client = RestClient.create(BASEURL);
        String result = client.get()
                .uri("/test0") // Endpoints shows just '/test0' without the baseURL
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /second/test0: \n it returns \"" + result + "\"");

    }
    // baseuri - constant, uri - inlined
    public void test1(){
        RestClient client = RestClient.create(BASEURL);

        String result = client.get()
                .uri("/test1") // ok
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test1: \n it returns \"" + result + "\"");

    }
    // all local vars
    public void test2(){
        String baseuri = "http://localhost:8080/second";
        String uri = "/test2/{pv}";
        RestClient client = RestClient.builder().baseUrl(baseuri).build();
        String result = client.get()
                .uri(uri, "foo")  // nothing in endpoints
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /second/test2: \n it returns \"" + result + "\"");

    }
    // all inlined
    public void test3(){
        RestClient client = RestClient.builder().baseUrl("http://localhost:8080/second").build();
        Pojo1 pojo  = new Pojo1("aaa","bbb");
        String response = client.post()
                .uri("/test3")  // ok
                .contentType(APPLICATION_JSON)
                .body(pojo)
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test3: \n it returns \"" + response + "\"");
    }

    // all constants
    public void test4(){
        RestClient client = RestClient.builder().baseUrl(BASEURL).build();

        String result = client.get()
                .uri(CONSTANT_URI, "foo")  // ok
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /second/test2: \n it returns \"" + result + "\"");

    }
    // mutate test:
    public void test5(){
        RestClient client = RestClient.builder().baseUrl("http://localhost:8080/foo").build();

        String response = client
                .mutate()
                .baseUrl("http://localhost:8080/second")
                .build()
                .get()
                .uri("/test5") // ok
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /first/test5: \n it returns \"" + response + "\"");
    }
}
