package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Component
public class WriteJob {

    @Autowired
    RestTemplate restTemplate;


    @Scheduled(fixedRate = 5*1000*60)
    public String getTelemetryDetails() throws IOException {

        String url = "https://whispering-temple-65255.herokuapp.com/xmlTelemetry";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
        System.out.println(response);
        FileWriter fw=new FileWriter("C:\\Users\\Padmaj\\write.txt");
        fw.write(response);




        return  response;




    }



}
