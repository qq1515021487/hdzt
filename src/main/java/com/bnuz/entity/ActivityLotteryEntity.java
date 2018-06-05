package com.bnuz.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

public class ActivityLotteryEntity {

    @ApiModelProperty("环节抽奖表uuid")
    private String alid;

    @ApiModelProperty("环节描述")
    private String description;

    @ApiModelProperty("背景图/背景视频链接")
    private String background;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("活动id")
    private String acid;

    @ApiModelProperty("其他需要显示的内容")
    private String otherContent;

    @ApiModelProperty("展示类型，1=正在展示，3=暂停（隐藏），5=结束")
    private Short showType;

    @ApiModelProperty("是否需要展示其他内容，0=否，1=是，如果为1展示other_content")
    private Byte needShowOtherContent;

    @ApiModelProperty("抽奖顺序，按照降序排序进行先后显示")
    private String sorted;

    @ApiModelProperty("奖品名")
    private String awardName;

    @ApiModelProperty("图片/视频url")
    private String awardPhoto;

    @ApiModelProperty("奖品的类别，特等奖/一等奖/二等奖..")
    private String awardType;

    @ApiModelProperty("获奖限定人数")
    private Integer person;

    @ApiModelProperty("已获奖人数")
    private Integer winners;

    @ApiModelProperty("每次同时抽奖的人数，即为每次抽多少个人，默认为1人")
    private Integer numbers;

    @ApiModelProperty("需要发送多少信息才能抽奖")
    private Integer limitSendMessageCount;

    @ApiModelProperty("是否先点需要发送消息，0=否，1=是，默认为1")
    private byte limitSendMessage;

    @ApiModelProperty("是否是私有的抽奖表，0=否，1=是，默认为0")
    private byte isCallOver;

    @ApiModelProperty("都且，还是都或者，0=且，1=或，默认为0")
    private byte logicType;

    @ApiModelProperty("发送的方式，是选择人工发送还是线上发送，0=人工，1=线上，如果为线上，则awardName需要只能输入2位小数，代表发红包")
    private byte sendType;

    public String getAlid() {
        return alid;
    }

    public void setAlid(String alid) {
        this.alid = alid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public Short getShowType() {
        return showType;
    }

    public void setShowType(Short showType) {
        this.showType = showType;
    }

    public Byte getNeedShowOtherContent() {
        return needShowOtherContent;
    }

    public void setNeedShowOtherContent(Byte needShowOtherContent) {
        this.needShowOtherContent = needShowOtherContent;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardPhoto() {
        return awardPhoto;
    }

    public void setAwardPhoto(String awardPhoto) {
        this.awardPhoto = awardPhoto;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getWinners() {
        return winners;
    }

    public void setWinners(Integer winners) {
        this.winners = winners;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getLimitSendMessageCount() {
        return limitSendMessageCount;
    }

    public void setLimitSendMessageCount(Integer limitSendMessageCount) {
        this.limitSendMessageCount = limitSendMessageCount;
    }

    public byte getLimitSendMessage() {
        return limitSendMessage;
    }

    public void setLimitSendMessage(byte limitSendMessage) {
        this.limitSendMessage = limitSendMessage;
    }

    public byte getIsCallOver() {
        return isCallOver;
    }

    public void setIsCallOver(byte isCallOver) {
        this.isCallOver = isCallOver;
    }

    public byte getLogicType() {
        return logicType;
    }

    public void setLogicType(byte logicType) {
        this.logicType = logicType;
    }

    public byte getSendType() {
        return sendType;
    }

    public void setSendType(byte sendType) {
        this.sendType = sendType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityLotteryEntity that = (ActivityLotteryEntity) o;

        if (alid != null ? !alid.equals(that.alid) : that.alid != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (background != null ? !background.equals(that.background) : that.background != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (otherContent != null ? !otherContent.equals(that.otherContent) : that.otherContent != null) return false;
        if (showType != null ? !showType.equals(that.showType) : that.showType != null) return false;
        if (needShowOtherContent != null ? !needShowOtherContent.equals(that.needShowOtherContent) : that.needShowOtherContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = alid != null ? alid.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (otherContent != null ? otherContent.hashCode() : 0);
        result = 31 * result + (showType != null ? showType.hashCode() : 0);
        result = 31 * result + (needShowOtherContent != null ? needShowOtherContent.hashCode() : 0);
        return result;
    }
}