package com.inovationlab.businessinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({
        "com.inovationlab.businessinfo.endpoint",
        "com.inovationlab.businessinfo.entity",
        "com.inovationlab.businessinfo.exception",
        "com.inovationlab.businessinfo.repositor",
        "com.inovationlab.businessinfo.service",
        "com.inovationlab.businessinfo.dto",
        "com.inovationlab.businessinfo.authentication",
        "com.inovationlab.businessinfo.config",
        "com.inovationlab.businessinfo.base"
})
public class BusinessInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessInfoApplication.class, args);
    }
}
