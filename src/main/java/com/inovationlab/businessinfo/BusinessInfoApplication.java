package com.inovationlab.businessinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class BusinessInfoApplication {
	public static void main(String[] args) {
		SpringApplication.run(BusinessInfoApplication.class, args);
	}

}
