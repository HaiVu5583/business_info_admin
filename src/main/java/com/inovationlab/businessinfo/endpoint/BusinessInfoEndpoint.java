package com.inovationlab.businessinfo.endpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessInfoEndpoint {
    @RequestMapping("/")
    String home() {
        return "Home Page";
    }

}
