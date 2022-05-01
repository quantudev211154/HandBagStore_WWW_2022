package com.g9.handbagstore.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPI {

    @GetMapping("")
    public String test(){
        return "Test API";
    }
}
