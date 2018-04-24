package com.day.sang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SangApplication {
    public static void main(String[] args) {
        SpringApplication.run(SangApplication.class, args);
    }
}
