package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.dto.LoginRequestDto;
import com.inovationlab.businessinfo.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthEndpoint extends AbstractEndpoint {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return getOkResponseEntity();
    }

    @PostMapping("/get_token")
    public ResponseEntity<?> getToken(@RequestBody LoginRequestDto loginRequest) {
        return getResponseEntity(authService.login(loginRequest));
    }

    @GetMapping("/partner_info")
    public ResponseEntity<?> userInfo() {
        return getResponseEntity(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
