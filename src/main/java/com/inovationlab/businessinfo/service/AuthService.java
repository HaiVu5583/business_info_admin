package com.inovationlab.businessinfo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.inovationlab.businessinfo.dto.LoginRequestDto;
import com.inovationlab.businessinfo.dto.LoginResponseDto;
import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.entity.User;
import com.inovationlab.businessinfo.exception.UserNotFoundException;
import com.inovationlab.businessinfo.repository.PartnerRepository;
import com.inovationlab.businessinfo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AuthService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expireTime}")
    private int jwtExpiry;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String generateJWTToken(User user) {
        Calendar expireTime = Calendar.getInstance();
        expireTime.add(Calendar.MINUTE, jwtExpiry);
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTCreator.Builder builder = JWT.create()
                .withExpiresAt(expireTime.getTime());
        builder.withClaim("username", user.getUsername());
        builder.withClaim("role", user.getRole());
        String token = builder.sign(algorithm);
        return token;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        User user = userRepository.findUser(requestDto.getUsername());
        if (user == null) {
            throw new UserNotFoundException();
        }
        boolean isMatched = passwordEncoder.matches(requestDto.getPassword(), user.getPassword());
        if (!isMatched) throw new UserNotFoundException();
        return new LoginResponseDto(user.getUsername(), generateJWTToken(user));
    }

}
