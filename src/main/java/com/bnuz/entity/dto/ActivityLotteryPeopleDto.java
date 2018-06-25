package com.bnuz.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "t_activity_lottery_people", schema = "hdzt")
public class ActivityLotteryPeopleDto {

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

    @ApiModelProperty("活动id")
    private String acid;




    @Id
    @Column(name = "alpid")
    public String getAlpid() {
        return alpid;
    }

    public void setAlpid(String alpid) {
        this.alpid = alpid;
    }

    @Column(name = "alid")
    public String getAlid() {
        return alid;
    }

    public void setAlid(String alid) {
        this.alid = alid;
    }

    @Basic
    @Column(name = "gain_time")
    public Long getGainTime() {
        return gainTime;
    }

    public void setGainTime(Long gainTime) {
        this.gainTime = gainTime;
    }

    @Basic
    @Column(name = "is_send")
    public Byte getIsSend() {
        return isSend;
    }

    public void setIsSend(Byte isSend) {
        this.isSend = isSend;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "award_qrcode")
    public String getAwardQrcode() {
        return awardQrcode;
    }

    public void setAwardQrcode(String awardQrcode) {
        this.awardQrcode = awardQrcode;
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
    @Column(name = "award_code")
    public Long getAwardCode() {
        return awardCode;
    }

    public void setAwardCode(Long awardCode) {
        this.awardCode = awardCode;
    }

    @Basic
    @Column(name = "acid")
    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }
}