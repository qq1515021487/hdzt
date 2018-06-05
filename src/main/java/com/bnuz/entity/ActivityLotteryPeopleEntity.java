package com.bnuz.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

public class ActivityLotteryPeopleEntity {

    @ApiModelProperty("获奖人名单UUID")
    private String alpid;

    @ApiModelProperty("环节抽奖表uuid")
    private String alid;

    @ApiModelProperty("获奖时间")
    private Long gainTime;

    @ApiModelProperty("是否已送出，0=否，1=是")
    private Byte isSend;

    @ApiModelProperty("如果活动抽奖不是私有的，则需要绑定获奖人的uuid")
    private String prid;

    @ApiModelProperty("获奖人名，如果是私有，直接从真名获得，如果是共有的抽奖，则从prid绑定的用户获得")
    private String name;

    @ApiModelProperty("获奖识别二维码")
    private String awardQrcode;

    @ApiModelProperty("是否有效，0=否，1=是，无效则用户搜索时显示奖品已过期")
    private Byte isFrozen;

    @ApiModelProperty("获奖识别码，6位数")
    private Long awardCode;

    @ApiModelProperty("活动ID")
    private String acid;

    public String getAlpid() {
        return alpid;
    }

    public void setAlpid(String alpid) {
        this.alpid = alpid;
    }

    public String getAlid() {
        return alid;
    }

    public void setAlid(String alid) {
        this.alid = alid;
    }

    public Long getGainTime() {
        return gainTime;
    }

    public void setGainTime(Long gainTime) {
        this.gainTime = gainTime;
    }

    public Byte getIsSend() {
        return isSend;
    }

    public void setIsSend(Byte isSend) {
        this.isSend = isSend;
    }

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAwardQrcode() {
        return awardQrcode;
    }

    public void setAwardQrcode(String awardQrcode) {
        this.awardQrcode = awardQrcode;
    }

    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Long getAwardCode() {
        return awardCode;
    }

    public void setAwardCode(Long awardCode) {
        this.awardCode = awardCode;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityLotteryPeopleEntity that = (ActivityLotteryPeopleEntity) o;

        if (alpid != null ? !alpid.equals(that.alpid) : that.alpid != null) return false;
        if (gainTime != null ? !gainTime.equals(that.gainTime) : that.gainTime != null) return false;
        if (isSend != null ? !isSend.equals(that.isSend) : that.isSend != null) return false;
        if (prid != null ? !prid.equals(that.prid) : that.prid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (awardQrcode != null ? !awardQrcode.equals(that.awardQrcode) : that.awardQrcode != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (awardCode != null ? !awardCode.equals(that.awardCode) : that.awardCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = alpid != null ? alpid.hashCode() : 0;
        result = 31 * result + (gainTime != null ? gainTime.hashCode() : 0);
        result = 31 * result + (isSend != null ? isSend.hashCode() : 0);
        result = 31 * result + (prid != null ? prid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (awardQrcode != null ? awardQrcode.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (awardCode != null ? awardCode.hashCode() : 0);
        return result;
    }
}