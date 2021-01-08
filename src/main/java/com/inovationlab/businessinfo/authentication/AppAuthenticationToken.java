package com.inovationlab.businessinfo.authentication;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inovationlab.businessinfo.entity.Partner;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AppAuthenticationToken extends AbstractAuthenticationToken {
    private AuthenticationInfo authenticationInfo;


    public static AppAuthenticationToken create(AuthenticationInfo authenticationInfo) {
        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        if (authenticationInfo != null) {
            authorities = Arrays.asList(new SimpleGrantedAuthority(authenticationInfo.getRole().toString()));
        }
        return new AppAuthenticationToken(authenticationInfo, authorities);
    }

    private AppAuthenticationToken(AuthenticationInfo authenticationInfo, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);

        this.authenticationInfo = authenticationInfo;

        super.setAuthenticated(true);
    }

    @JsonInclude
    @Override
    public AuthenticationInfo getPrincipal() {
        return this.authenticationInfo;
    }

    @JsonInclude
    @Override
    public Object getCredentials() {
        return null;
    }

    public AuthenticationInfo getAuthenticationInfo() {
        return authenticationInfo;
    }

    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        this.authenticationInfo = authenticationInfo;
    }
}
