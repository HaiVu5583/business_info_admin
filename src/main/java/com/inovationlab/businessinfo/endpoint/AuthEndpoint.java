package com.inovationlab.businessinfo.endpoint;

import com.inovationlab.businessinfo.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthEndpoint extends AbstractEndpoint {
    final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthService authService;

    @RequestMapping("/test")
    public ResponseEntity<?> test(@RequestHeader("PARTNER_CODE") String partnerCode, @RequestHeader("PARTNER_SECRET") String partnerSecret) {
        boolean isValidPartner = authService.isValidPartner(partnerCode, partnerSecret);
        if (!isValidPartner){
            return new ResponseEntity<>(AppResponse.getUnauthrizedResponse() , HttpStatus.UNAUTHORIZED);
        }
        return getOkResponseEntity();
    }

    @RequestMapping("/userinfo")
    public ResponseEntity<?> userInfo() {
        return getOkResponseEntity();
    }

}
