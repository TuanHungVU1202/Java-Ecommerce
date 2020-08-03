package com.hv.ecommerce.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthcheck {
    @GetMapping("/healthcheck")
    public String getHealthCheck() {
        return "ok";
    }
}
