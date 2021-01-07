package com.inovationlab.businessinfo.authentication;

import com.inovationlab.businessinfo.domain.Partner;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AppAuthentication extends AbstractAuthenticationToken {
    private Partner partnerInfo;

    public AppAuthentication(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
