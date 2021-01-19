package com.example.graalvm.springbootgraalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        proxyBeanMethods = false
)
public class SpringBootGraalvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraalvmApplication.class, args);
    }
}
