package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_history", schema = "hdzt")
public class ActivityHistoryEntity {
    private String ahid;
    private String acid;
    private String detail;
    private String uid;
    private Long operateTime;

    @Id
    @Column(name = "ahid")
    public String getAhid() {
        return ahid;
    }

    public void setAhid(String ahid) {
        this.ahid = ahid;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "operate_time")
    public Long getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Long operateTime) {
        this.operateTime = operateTime;
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
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityHistoryEntity that = (ActivityHistoryEntity) o;

        if (ahid != null ? !ahid.equals(that.ahid) : that.ahid != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;

        return true;
    }

}