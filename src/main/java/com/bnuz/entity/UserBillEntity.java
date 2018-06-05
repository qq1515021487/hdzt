package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user_bill", schema = "hdzt")
public class UserBillEntity {
    private String bhid;
    private Long operateTime;
    private String detail;
    private Long money;
    private String uid;
    private String acid;
    private Integer type;

    @Id
    @Column(name = "bhid")
    public String getBhid() {
        return bhid;
    }

    public void setBhid(String bhid) {
        this.bhid = bhid;
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
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "money")
    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBillEntity that = (UserBillEntity) o;

        if (bhid != null ? !bhid.equals(that.bhid) : that.bhid != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bhid != null ? bhid.hashCode() : 0;
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}