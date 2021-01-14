package com.inovationlab.businessinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localhost:8000");
            }
        };
    }
}
