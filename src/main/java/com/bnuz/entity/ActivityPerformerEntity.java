package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_performer", schema = "hdzt")
public class ActivityPerformerEntity {
    private String apid;
    private String acid;
    private String attendentId;
    private String prid;
    private Byte isFrozen;
    private Byte isCheck;
    private Long addTime;

    @Id
    @Column(name = "apid")
    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
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
    @Column(name = "attendent_id")
    public String getAttendentId() {
        return attendentId;
    }

    public void setAttendentId(String attendentId) {
        this.attendentId = attendentId;
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
    @Column(name = "is_frozen")
    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    @Basic
    @Column(name = "is_check")
    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    @Basic
    @Column(name = "add_time")
    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityPerformerEntity that = (ActivityPerformerEntity) o;

        if (apid != null ? !apid.equals(that.apid) : that.apid != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (isCheck != null ? !isCheck.equals(that.isCheck) : that.isCheck != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apid != null ? apid.hashCode() : 0;
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (isCheck != null ? isCheck.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }
}