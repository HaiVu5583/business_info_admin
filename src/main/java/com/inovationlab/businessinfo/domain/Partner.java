package com.inovationlab.businessinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "partner")

public class Partner {
    @Id
    @Column(name = "partner_code")
    private String partnerCode;
    @Column(name = "partner_secret")
    private String partnerSecret;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Partner() {
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public Partner(String partnerCode, String partnerSecret) {
        this.partnerCode = partnerCode;
        this.partnerSecret = partnerSecret;
    }


    public Partner(String partnerCode, String partnerSecret, Timestamp createdAt, Timestamp updatedAt) {
        this.partnerCode = partnerCode;
        this.partnerSecret = partnerSecret;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
