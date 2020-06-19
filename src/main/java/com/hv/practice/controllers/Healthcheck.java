package com.hv.practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthcheck {
    @GetMapping("health")
    public String getHealthCheck(){
        return "OK!";
    }
}
