package com.inovationlab.businessinfo.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.entity.User;
import com.inovationlab.businessinfo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationManager {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public AppAuthenticationToken getAuthenticationByJwtToken(String jwtToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(jwtToken);
            String username = jwt.getClaim("username").asString();
            String role = jwt.getClaim("role").asString();
            logger.info("Username: " + username);
            logger.info("Role: " + role);
            User user = new User();
            user.setUsername(username);
            user.setRole(role);
            AuthenticationInfo authenticationInfo = AuthenticationInfo.createByUser(user);
            AppAuthenticationToken appAuthenticationToken = AppAuthenticationToken.create(authenticationInfo);
            return appAuthenticationToken;
        } catch (JWTVerificationException exception){
            return null;
        }
    }
}
