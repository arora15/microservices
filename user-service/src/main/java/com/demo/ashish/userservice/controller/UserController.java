package com.demo.ashish.userservice.controller;

import com.demo.ashish.userservice.dto.UserDepartmentDTO;
import com.demo.ashish.userservice.entity.User;
import com.demo.ashish.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ServletWebServerApplicationContext server;

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String userGreeting()
    {
        log.info("Inside the userGreeting Method of the UserController");
        return "Greeting from User Service. The Server Port : "+server.getWebServer().getPort();
    }

    @GetMapping("/getuser/{id}")
    public UserDepartmentDTO getuser(@PathVariable("id") Long userId)
    {
        log.info("Inside the getuser Method of the UserController");
        return userService.getUserById(userId);
    }

    @GetMapping("/getusers")
    public List<UserDepartmentDTO> getusers()
    {
        log.info("Inside the getusers Method of the UserController");
        return userService.getAllUsers();
    }

    @PutMapping("/storeuser")
    public User adduser(@RequestBody User user)
    {
        log.info("Inside the adduser Method of the UserController");
        return this.userService.saveUser(user);
    }
}
