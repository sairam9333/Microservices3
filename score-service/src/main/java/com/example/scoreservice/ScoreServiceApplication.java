package com.example.scoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the score service. As with other microservices, the
 * {@code @SpringBootApplication} annotation enables component scanning and
 * auto‑configuration.
 */
@SpringBootApplication
public class ScoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoreServiceApplication.class, args);
    }
}
