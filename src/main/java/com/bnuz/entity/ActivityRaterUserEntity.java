package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_rater_user", schema = "hdzt")
public class ActivityRaterUserEntity {
    private String rid;
    private String raterName;
    private String code;
    private String qrCode;
    private String prid;
    private String acid;
    private Byte isFrozen;

    @Id
    @Column(name = "rid")
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "rater_name")
    public String getRaterName() {
        return raterName;
    }

    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "qr_code")
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "prid")
    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    @Basic
    @Column(name = "acid")
    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    @Basic
    @Column(name = "is_frozen")
    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityRaterUserEntity that = (ActivityRaterUserEntity) o;

        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;
        if (raterName != null ? !raterName.equals(that.raterName) : that.raterName != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid != null ? rid.hashCode() : 0;
        result = 31 * result + (raterName != null ? raterName.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (qrCode != null ? qrCode.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        return result;
    }
}