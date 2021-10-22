package com.example.demo.controller;

import com.example.demo.utils.JAxbconvert;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Component
@EnableScheduling
public class ReadJob {



    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 1000*60)
    public  String getTelemetryDetails() throws IOException {

        String url = "https://whispering-temple-65255.herokuapp.com/xmlTelemetry";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
        log.info(response);
        FileWriter fw=new FileWriter("C:\\Users\\M.PadmajMilan\\read.txt");
        JSONObject jsonResponse = JAxbconvert.convertXmlToJson(response);

        System.out.println(jsonResponse);

        fw.write(jsonResponse.toString());




        return  response;




    }


    public static void main(String[] args) throws IOException {


        ReadJob r = new ReadJob();
        log.info(r.getTelemetryDetails());


    }







}
