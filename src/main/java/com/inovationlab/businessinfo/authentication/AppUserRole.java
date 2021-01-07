package com.inovationlab.businessinfo.authentication;

import com.inovationlab.businessinfo.base.BaseEnum;

public enum AppUserRole {
    PARTNER("ROLE_PARTNER"),
    USER("ROLE_USER");

    private final String role;
    private AppUserRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
