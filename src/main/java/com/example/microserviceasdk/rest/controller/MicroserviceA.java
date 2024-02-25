package com.example.microserviceasdk.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/get")
public class MicroserviceA {
	
	
    private List<String> data = List.of("Data1", "Data2", "Data3");
    
    
    @GetMapping("/data")
    public List<String> getDetails() {
        return data;
    }

}
