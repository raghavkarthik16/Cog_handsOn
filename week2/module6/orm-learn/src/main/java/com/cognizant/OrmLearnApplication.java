package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrmLearnApplication.class, args);

        System.out.println("Inside Main");

    }
}