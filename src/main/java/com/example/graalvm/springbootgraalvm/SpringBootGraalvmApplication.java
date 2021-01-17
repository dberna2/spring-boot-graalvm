package com.example.graalvm.springbootgraalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(
        exclude = {
                SpringDataWebAutoConfiguration.class
        },
        proxyBeanMethods = false
)
public class SpringBootGraalvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraalvmApplication.class, args);
    }

}
