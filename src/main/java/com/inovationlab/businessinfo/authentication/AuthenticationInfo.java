package com.inovationlab.businessinfo.authentication;

import com.inovationlab.businessinfo.entity.Partner;
import com.inovationlab.businessinfo.entity.User;

public class AuthenticationInfo {
    private AppUserRole role;
    private String partnerCode;
    private String partnerSecret;
    private String username;

    public AuthenticationInfo() {
    }

    public AuthenticationInfo(AppUserRole role, String partnerCode, String partnerSecret, String username) {
        this.role = role;
        this.partnerCode = partnerCode;
        this.partnerSecret = partnerSecret;
        this.username = username;
    }

    public AppUserRole getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerSecret() {
        return partnerSecret;
    }

    public void setPartnerSecret(String partnerSecret) {
        this.partnerSecret = partnerSecret;
    }

    public static final AuthenticationInfo createByPartner(Partner partner) {
        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setRole(AppUserRole.PARTNER);
        authenticationInfo.setPartnerCode(partner.getPartnerCode());
        authenticationInfo.setPartnerSecret(partner.getPartnerSecret());
        return authenticationInfo;
    }

    public static final AuthenticationInfo createByUser(User user) {
        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setRole(AppUserRole.USER);
        authenticationInfo.setUsername(user.getUsername());
        return authenticationInfo;
    }
}
