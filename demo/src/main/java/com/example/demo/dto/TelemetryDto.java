package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Getter
@Setter
public class TelemetryDto {

    @XmlAttribute
    private String id;
    private int temperature;
    private int humidity;
    private String location;


    @XmlElement(name = "publish_date")
    private String timestamp;









}
