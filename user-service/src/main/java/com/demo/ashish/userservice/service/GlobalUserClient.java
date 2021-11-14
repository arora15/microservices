package com.demo.ashish.userservice.service;

import com.demo.ashish.userservice.dto.GlobalUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name = "GLOBAL-USERCLIENT")
public interface GlobalUserClient {

    @GetMapping("/users")
    public List<GlobalUser> getUsers();
}
