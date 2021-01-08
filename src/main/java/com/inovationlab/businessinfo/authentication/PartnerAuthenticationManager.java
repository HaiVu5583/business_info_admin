package com.inovationlab.businessinfo.authentication;

import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerAuthenticationManager {
    @Autowired
    PartnerRepository partnersRepository;

    public AppAuthenticationToken getAuthenticationByPartnerCodeSecret(String partnersCode, String partnersSecret) {
        List<Partner> partners = partnersRepository.findPartnerByCodeAndSecret(partnersCode, partnersSecret);
        if (partners == null || partners.size() == 0) return null;

        AuthenticationInfo authenticationInfo = AuthenticationInfo.createByPartner(partners.get(0));
        AppAuthenticationToken appAuthenticationToken = AppAuthenticationToken.create(authenticationInfo);
        return appAuthenticationToken;
    }
}
