package com.example.dockerizedsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
public class DockerizedsampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerizedsampleApplication.class, args);
    }

}
