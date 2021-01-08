package com.inovationlab.businessinfo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.repository.PartnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expireTime}")
    private int jwtExpiry;

    @Autowired
    private PartnerRepository partnerRepository;
    public boolean isValidPartner(String partnerCode, String partnerSecret){
        List<Partner> partners = partnerRepository.findPartnerByCodeAndSecret(partnerCode, partnerSecret);
        return partners.size() == 1;
    }

    public String generateJWTToken(Map<String, String> data){
        Calendar expireTime = Calendar.getInstance();
        expireTime.add(Calendar.MINUTE, jwtExpiry);
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTCreator.Builder builder = JWT.create()
                .withExpiresAt(expireTime.getTime());
        for (Map.Entry<String, String> item: data.entrySet()){
            builder.withClaim(item.getKey(), item.getValue());
        }
        String token = builder.sign(algorithm);
        return token;
    }


}
