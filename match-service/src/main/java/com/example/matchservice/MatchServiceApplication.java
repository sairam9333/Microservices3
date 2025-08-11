package com.example.matchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the match service.  The {@code @SpringBootApplication} annotation
 * triggers component scanning, auto–configuration and other features necessary to
 * bootstrap a Spring application【28841497750044†L245-L279】.
 */
@SpringBootApplication
public class MatchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchServiceApplication.class, args);
    }
}
