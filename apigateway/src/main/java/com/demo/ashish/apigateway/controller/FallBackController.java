package com.demo.ashish.apigateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/fallback")
public class FallBackController {
    
    @GetMapping("/userfallback")
    public String userServiceFallbackMethod()
    {
        log.error("Inside the userServiceFallbackMethod Method of the FallBackController");
        return "User Service is not Responding!! Please See the User Service logs for More Info!!";
    }
    @GetMapping("/departmentfallback")
    public String departmentServiceFallbackMethod()
    {
        log.error("Inside the departmentServiceFallbackMethod Method of the FallBackController");
        return "Department Service is not Responding!! Please See the Department Service logs for More Info!!";
    }
}
