package com.rishab.helloworld;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rishab.helloworld.controller.GreetingController;
import com.rishab.helloworld.pojo.Greeting;
import com.rishab.helloworld.repository.GreetingRepository;

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
}
