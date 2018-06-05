package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_outfit_function", schema = "hdzt")
public class OutfitFunctionEntity {
    private Long ofid;
    private String oid;
    private Long fid;
    private Long endTime;
    private Byte isFrozen;
    private Long startTime;

    @Id
    @Column(name = "ofid")
    public Long getOfid() {
        return ofid;
    }

    public void setOfid(Long ofid) {
        this.ofid = ofid;
    }

    @Basic
    @Column(name = "end_time")
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "oid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "fid")
    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
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
    @Column(name = "start_time")
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutfitFunctionEntity that = (OutfitFunctionEntity) o;

        if (ofid != that.ofid) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

}