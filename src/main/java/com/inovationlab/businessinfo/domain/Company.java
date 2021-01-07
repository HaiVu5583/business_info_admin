package com.inovationlab.businessinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "f_company")
public class Company {

    @Id
    @Column(name = "tax_code", nullable = false)
    private String taxCode;

    @Column(name = "name")
    private String name;

    @Column(name = "transaction_name")
    private String transactionName;

    @Column(name = "issued_date")
    private String issuedDate;

    @Column(name = "active_status")
    private String activeStatus;

    @Column(name = "headquater_address")
    private String headquaterAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "owner")
    private String owner;

    @Column(name = "owner_address")
    private String ownerAddress;

    @Column(name = "manager")
    private String manager;

    @Column(name = "fax")
    private String fax;

    @Column(name = "primary_business")
    private String primaryBusiness;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "tax_department")
    private String taxDepartment;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "source")
    private Integer source;

    @Column(name = "session_id")
    private Long sessionId;

    public Company() {
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getHeadquaterAddress() {
        return headquaterAddress;
    }

    public void setHeadquaterAddress(String headquaterAddress) {
        this.headquaterAddress = headquaterAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPrimaryBusiness() {
        return primaryBusiness;
    }

    public void setPrimaryBusiness(String primaryBusiness) {
        this.primaryBusiness = primaryBusiness;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTaxDepartment() {
        return taxDepartment;
    }

    public void setTaxDepartment(String taxDepartment) {
        this.taxDepartment = taxDepartment;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
