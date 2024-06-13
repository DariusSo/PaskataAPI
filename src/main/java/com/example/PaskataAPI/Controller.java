package com.example.PaskataAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/first")
    public String firstEndPoint(){
        return "My first Endpoint response to your request";
    }
}
