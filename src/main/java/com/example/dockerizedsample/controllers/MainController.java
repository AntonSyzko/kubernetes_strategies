package com.example.dockerizedsample.controllers;

import com.example.dockerizedsample.model.User;
import com.example.dockerizedsample.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/demo")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Value("message.to.show")
    private String message;

    @Autowired
    private Environment environment;

    @Autowired
    private UserService userService;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User user= new User();
        user.setName(name);
        user.setEmail(email);
        userService.saveUser(user);
        logger.info("Saved user :{} ", user);
        return "Saved" + name + " " + email;
    }

    @Cacheable("users")
    @GetMapping(path="/all")
    public @ResponseBody List<User> getAllUsers() {
        logger.info(" showing all users ");
        return userService.getAllUsers();
    }

    @DeleteMapping(path="/remove/")
    public @ResponseBody List<User> deleteUserByEmail() {
        logger.info("deleting user ");
        return userService.getAllUsers();
    }

    @Profile("prod")
    @GetMapping("/home/prod")
    public String homeProd() {
        logger.info("accessed PROD profile");
        return "Hello PROD ";
    }

    @Profile("uat")
    @GetMapping("/home/uat")
    public String homeUat() {
        logger.info("accessed UAT profile");
        return "Hello UAT ";
    }

    @GetMapping("/message")
    public String messageToShow() {
        logger.info(" showing environment dependent message, active profiles  {} ", environment.getActiveProfiles());
        return environment.getProperty("message.to.show");
    }
}