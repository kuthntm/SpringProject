package com.example.SpringProject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API용 컨트롤러
public class FirstApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "hello world";
    }
}
