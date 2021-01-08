package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthEndpoint extends AbstractEndpoint {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthService authService;

    @RequestMapping("/test")
    public ResponseEntity<?> test() {
        return getOkResponseEntity();
    }

    @RequestMapping("/get_token")
    public ResponseEntity<?> getToken(){
        Map data = new HashMap<String, String>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        logger.info("Token: " + authService.generateJWTToken(data));
        return getOkResponseEntity();
    }

    @RequestMapping("/partner_info")
    public ResponseEntity<?> userInfo() {
        return getResponseEntity(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
