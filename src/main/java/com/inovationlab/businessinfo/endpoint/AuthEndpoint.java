package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.dto.LoginRequestDto;
import com.inovationlab.businessinfo.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthEndpoint extends AbstractEndpoint {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        String pass1 = passwordEncoder.encode("123456");
        String pass2 = passwordEncoder.encode("123456");
        logger.info("pass1: " + pass1);
        logger.info("pass2: " + pass2);
        String passEncodeFromWeb = "$2y$12$P2p24MrGx1gG7A24vts4FOMi0hlh/8EIA2X3cDTvorWvheW3KTjuW";
        logger.info("Is matched passs: " + passwordEncoder.matches("123456", passEncodeFromWeb));
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
