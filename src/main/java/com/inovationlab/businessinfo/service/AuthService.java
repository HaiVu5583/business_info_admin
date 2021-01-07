package com.inovationlab.businessinfo.service;

import com.inovationlab.businessinfo.domain.Partner;
import com.inovationlab.businessinfo.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private PartnerRepository partnerRepository;
    public boolean isValidPartner(String partnerCode, String partnerSecret){
        List<Partner> partners = partnerRepository.findPartnerByCodeAndSecret(partnerCode, partnerSecret);
        return partners.size() == 1;
    }
}
