package com.inovationlab.businessinfo.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inovationlab.businessinfo.endpoint.AppResponse;
import com.inovationlab.businessinfo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {
    private static final String PARTNER_CODE_HEADER_NAME = "PARTNER_CODE";
    private static final String PARTNER_SECRET_HEADER_NAME = "PARTNER_SECRET";
    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String partnerCode = request.getHeader(PARTNER_CODE_HEADER_NAME);
        String partnerSecret = request.getHeader(PARTNER_SECRET_HEADER_NAME);
        if (partnerCode == null || partnerSecret == null){
            setUnauthorizedErrorResponse(response);
            return;
        }
        boolean isValidPartner = authService.isValidPartner(partnerCode, partnerSecret);
        if (!isValidPartner){
            setUnauthorizedErrorResponse(response);
            return;
        }

        SecurityContext securityContext = SecurityContextHolder.getContext();
//        securityContext.setAuthentication();
        filterChain.doFilter(request, response);
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private void setUnauthorizedErrorResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(convertObjectToJson(AppResponse.getUnauthrizedResponse()));
    }
}
