package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_function", schema = "hdzt")
public class ActivityFunctionEntity {
    private Long fid;
    private String name;
    private String description;
    private Byte isFrozen;
    private Long sorted;
    private Byte useful;
    private Byte needPay;
    private Long payMoney;

    @Id
    @Column(name = "fid")
    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "sorted")
    public Long getSorted() {
        return sorted;
    }

    public void setSorted(Long sorted) {
        this.sorted = sorted;
    }

    @Basic
    @Column(name = "useful")
    public Byte getUseful() {
        return useful;
    }

    public void setUseful(Byte useful) {
        this.useful = useful;
    }

    @Basic
    @Column(name = "need_pay")
    public Byte getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Byte needPay) {
        this.needPay = needPay;
    }

    @Basic
    @Column(name = "pay_money")
    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityFunctionEntity that = (ActivityFunctionEntity) o;

        if (fid != that.fid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;
        if (useful != null ? !useful.equals(that.useful) : that.useful != null) return false;
        if (needPay != null ? !needPay.equals(that.needPay) : that.needPay != null) return false;
        if (payMoney != null ? !payMoney.equals(that.payMoney) : that.payMoney != null) return false;

        return true;
    }


}