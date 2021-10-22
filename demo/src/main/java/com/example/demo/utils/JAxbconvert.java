package com.example.demo.utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.*;

import java.time.LocalDate;

public class JAxbconvert {

    public static JSONObject convertXmlToJson(String request){

        JSONObject json = XML.toJSONObject(request);


        return json;





    }



    public static JSONObject addTimeStamp(JSONObject request){

        request.append("timestamp", LocalDate.now());


        return request;





    }



}
