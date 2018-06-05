package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_outfit_info", schema = "hdzt")
public class OutfitInfoEntity {
    private String oid;
    private String username;
    private String password;
    private String outfitName;
    private Long cityId;
    private String contactTel;
    private String contactEmail;
    private String contactName;
    private String proveData;
    private String outfitIcon;
    private String identifyCard;
    private Long verityStatus;
    private String verityMessage;
    private Long outfitType;
    private String checkerName;
    private Long lastLoginTime;
    private String lastLoginIp;

    @Id
    @Column(name = "oid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "outfit_name")
    public String getOutfitName() {
        return outfitName;
    }

    public void setOutfitName(String outfitName) {
        this.outfitName = outfitName;
    }

    @Basic
    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Basic
    @Column(name = "contact_email")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "contact_name")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "prove_data")
    public String getProveData() {
        return proveData;
    }

    public void setProveData(String proveData) {
        this.proveData = proveData;
    }

    @Basic
    @Column(name = "outfit_icon")
    public String getOutfitIcon() {
        return outfitIcon;
    }

    public void setOutfitIcon(String outfitIcon) {
        this.outfitIcon = outfitIcon;
    }

    @Basic
    @Column(name = "identify_card")
    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    @Basic
    @Column(name = "verity_status")
    public Long getVerityStatus() {
        return verityStatus;
    }

    public void setVerityStatus(Long verityStatus) {
        this.verityStatus = verityStatus;
    }

    @Basic
    @Column(name = "verity_message")
    public String getVerityMessage() {
        return verityMessage;
    }

    public void setVerityMessage(String verityMessage) {
        this.verityMessage = verityMessage;
    }

    @Basic
    @Column(name = "outfit_type")
    public Long getOutfitType() {
        return outfitType;
    }

    public void setOutfitType(Long outfitType) {
        this.outfitType = outfitType;
    }

    @Basic
    @Column(name = "checker_name")
    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    @Basic
    @Column(name = "last_login_time")
    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "last_login_ip")
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutfitInfoEntity that = (OutfitInfoEntity) o;

        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (outfitName != null ? !outfitName.equals(that.outfitName) : that.outfitName != null) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (contactTel != null ? !contactTel.equals(that.contactTel) : that.contactTel != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (proveData != null ? !proveData.equals(that.proveData) : that.proveData != null) return false;
        if (outfitIcon != null ? !outfitIcon.equals(that.outfitIcon) : that.outfitIcon != null) return false;
        if (identifyCard != null ? !identifyCard.equals(that.identifyCard) : that.identifyCard != null) return false;
        if (verityStatus != null ? !verityStatus.equals(that.verityStatus) : that.verityStatus != null) return false;
        if (verityMessage != null ? !verityMessage.equals(that.verityMessage) : that.verityMessage != null)
            return false;
        if (outfitType != null ? !outfitType.equals(that.outfitType) : that.outfitType != null) return false;
        if (checkerName != null ? !checkerName.equals(that.checkerName) : that.checkerName != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(that.lastLoginIp) : that.lastLoginIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid != null ? oid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (outfitName != null ? outfitName.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (contactTel != null ? contactTel.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (proveData != null ? proveData.hashCode() : 0);
        result = 31 * result + (outfitIcon != null ? outfitIcon.hashCode() : 0);
        result = 31 * result + (identifyCard != null ? identifyCard.hashCode() : 0);
        result = 31 * result + (verityStatus != null ? verityStatus.hashCode() : 0);
        result = 31 * result + (verityMessage != null ? verityMessage.hashCode() : 0);
        result = 31 * result + (outfitType != null ? outfitType.hashCode() : 0);
        result = 31 * result + (checkerName != null ? checkerName.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        return result;
    }
}