package com.example.demo.controller;


import com.example.demo.exceptions.WalmartExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WalmartController {

    @Autowired
    ReadJob readJob;


    private static Map<Integer,String> map = new HashMap<Integer,String>();

    @GetMapping("/readJob")
    public void readJob() throws IOException {

      String details =  readJob.getTelemetryDetails();
        System.out.println("the xml content in the controller:"+details);



    }



}
