package com.bnuz.entity.dto;

import com.bnuz.entity.ActivityEntity;
import com.bnuz.entity.CityEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "t_activity", schema = "hdzt")
public class ActivityDto {

    @Id
    @Column(name = "acid")
    @ApiModelProperty("活动表uuid")
    private String acid;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动简介")
    private String description;

    // 不需要被注入到数据库中
    @Transient
    @ApiModelProperty("活动所在的城市id")
    private Long cityId;

    @JsonIgnore
    @ApiModelProperty("创建活动人的uid")
    private String uid;

    @ApiModelProperty("活动开始时间")
    private Long startTime;

    @ApiModelProperty("活动截止时间")
    private Long endTime;

    @ApiModelProperty("参与者最多人数")
    private int memberMaxCount;

    @ApiModelProperty("是否能被官网推荐，0=不允许，1=允许，默认为0")
    private Byte recommed;

    @ApiModelProperty("活动区域限定，0=不限定，1=限定，默认为0")
    private Byte locateLimit;

    @ApiModelProperty("活动区域限定距离，如果活动被限定的话")
    private Long locateLimitDistance;

    @ApiModelProperty("最后修改时间")
    private Long lastUpdateTime;

    @ApiModelProperty("活动详情")
    private String content;

    @ApiModelProperty("活动准确经度")
    private Integer longitude;

    @ApiModelProperty("活动准确维度")
    private Integer latitude;

    @ApiModelProperty("是否需要评委，如果是则需要导入评委列表，0=否，1=是，默认为0")
    private Byte limitRater;

    @ApiModelProperty("审核消息方法，1=自动审核，通过铭感词库过滤，3=人工审核")
    private Byte limitNote;

    @ApiModelProperty("活动弹幕是否显示微信昵称，0=否，1=是，如果不显示，则显示自行填写的昵称")
    private Byte limitShowNickName;

    @ApiModelProperty("是否限定活动只有签到名单上的人能进行，0=否，1=是，默认为0")
    private Byte limitCallover;

    @ApiModelProperty("评委码，如果需要评委，扫描评委码即可进入评委模式")
    private String raterCode;

    @ApiModelProperty("评委二维码，如果需要评委，扫描评委码即可进入评委模式")
    private String raterQrCode;

    @ApiModelProperty("参选者码，6位校验码")
    private String performerCode;

    @ApiModelProperty("参选者二维码")
    private String performerQrCode;

    @ApiModelProperty("活动是否能进行，0=否，1=是，默认为1")
    private Byte isFrozen;

    @ApiModelProperty("签到类型，1=不用签到，昵称与微信昵称一致，3=签到表签到，不需要签到的昵称与微信一致，点击签到后更改昵称，5=硬性签到，必须填写昵称")
    private Byte isRegister;

    @ApiModelProperty("参与活动人数，活动最后统计")
    private Long memberCount;

    @ApiModelProperty("活动墙发送信息数，活动最后统计")
    private Long informations;

    @ApiModelProperty("活动码，6位校验码")
    private String activityCode;

    @ApiModelProperty("活动二维码")
    private String qrCode;

    @ApiModelProperty("微信公众号二维码")
    private String wechatQrCode;

    @ApiModelProperty("微信公众号")
    private String wechatPublicNumber;

    @ApiModelProperty("创建活动时间")
    private Long createTime;

    @ApiModelProperty("是否将该活动分布在其他服务器上，0=否，1=是")
    private Byte isDispersed;

    @ApiModelProperty("分布式ip，如果是否分布式为1")
    private String dispersedIp;

    @Basic
    @Column(name = "activity_status")
    @ApiModelProperty("活动状态，1=试用中，3=正式发布，5=结束")
    private int activityStatus;

    @ApiModelProperty("城市信息")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;


    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

    private Byte function1;
    private Byte function2;
    private Byte function3;
    private Byte function4;
    private Byte function5;
    private Byte function6;
    private Byte function7;
    private Byte function8;
    private Byte function9;
    private Byte function10;
    private Byte function11;
    private Byte function12;
    private Byte function13;
    private Byte function14;
    private Byte function15;
    private Byte function16 ;



    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }


    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Basic
    @Column(name = "activity_name")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
    @Column(name = "start_time")
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
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
    @Column(name = "member_max_count")
    public int getMemberMaxCount() {
        return memberMaxCount;
    }

    public void setMemberMaxCount(int memberMaxCount) {
        this.memberMaxCount = memberMaxCount;
    }

    @Basic
    @Column(name = "recommed")
    public Byte getRecommed() {
        return recommed;
    }

    public void setRecommed(Byte recommed) {
        this.recommed = recommed;
    }

    @Basic
    @Column(name = "locate_limit")
    public Byte getLocateLimit() {
        return locateLimit;
    }

    public void setLocateLimit(Byte locateLimit) {
        this.locateLimit = locateLimit;
    }

    @Basic
    @Column(name = "locate_limit_distance")
    public Long getLocateLimitDistance() {
        return locateLimitDistance;
    }

    public void setLocateLimitDistance(Long locateLimitDistance) {
        this.locateLimitDistance = locateLimitDistance;
    }

    @Basic
    @Column(name = "last_update_time")
    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "longitude")
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "limit_rater")
    public Byte getLimitRater() {
        return limitRater;
    }

    public void setLimitRater(Byte limitRater) {
        this.limitRater = limitRater;
    }

    @Basic
    @Column(name = "limit_note")
    public Byte getLimitNote() {
        return limitNote;
    }

    public void setLimitNote(Byte limitNote) {
        this.limitNote = limitNote;
    }

    @Basic
    @Column(name = "limit_show_nick_name")
    public Byte getLimitShowNickName() {
        return limitShowNickName;
    }

    public void setLimitShowNickName(Byte limitShowNickName) {
        this.limitShowNickName = limitShowNickName;
    }

    @Basic
    @Column(name = "limit_callover")
    public Byte getLimitCallover() {
        return limitCallover;
    }

    public void setLimitCallover(Byte limitCallover) {
        this.limitCallover = limitCallover;
    }

    @Basic
    @Column(name = "rater_code")
    public String getRaterCode() {
        return raterCode;
    }

    public void setRaterCode(String raterCode) {
        this.raterCode = raterCode;
    }

    @Basic
    @Column(name = "rater_qr_code")
    public String getRaterQrCode() {
        return raterQrCode;
    }

    public void setRaterQrCode(String raterQrCode) {
        this.raterQrCode = raterQrCode;
    }

    @Basic
    @Column(name = "performer_code")
    public String getPerformerCode() {
        return performerCode;
    }

    public void setPerformerCode(String performerCode) {
        this.performerCode = performerCode;
    }

    @Basic
    @Column(name = "performer_qr_code")
    public String getPerformerQrCode() {
        return performerQrCode;
    }

    public void setPerformerQrCode(String performerQrCode) {
        this.performerQrCode = performerQrCode;
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
    @Column(name = "is_register")
    public Byte getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Byte isRegister) {
        this.isRegister = isRegister;
    }

    @Basic
    @Column(name = "member_count")
    public Long getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Long memberCount) {
        this.memberCount = memberCount;
    }

    @Basic
    @Column(name = "informations")
    public Long getInformations() {
        return informations;
    }

    public void setInformations(Long informations) {
        this.informations = informations;
    }

    @Basic
    @Column(name = "activity_code")
    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
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
    @Column(name = "wechat_qr_code")
    public String getWechatQrCode() {
        return wechatQrCode;
    }

    public void setWechatQrCode(String wechatQrCode) {
        this.wechatQrCode = wechatQrCode;
    }

    @Basic
    @Column(name = "wechat_public_number")
    public String getWechatPublicNumber() {
        return wechatPublicNumber;
    }

    public void setWechatPublicNumber(String wechatPublicNumber) {
        this.wechatPublicNumber = wechatPublicNumber;
    }

    @Basic
    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "is_dispersed")
    public Byte getIsDispersed() {
        return isDispersed;
    }

    public void setIsDispersed(Byte isDispersed) {
        this.isDispersed = isDispersed;
    }

    @Basic
    @Column(name = "dispersed_ip")
    public String getDispersedIp() {
        return dispersedIp;
    }

    public void setDispersedIp(String dispersedIp) {
        this.dispersedIp = dispersedIp;
    }

    @Basic
    @Column(name = "function1")
    public Byte getFunction1() {
        return function1;
    }

    public void setFunction1(Byte function1) {
        this.function1 = function1;
    }

    @Basic
    @Column(name = "function2")
    public Byte getFunction2() {
        return function2;
    }

    public void setFunction2(Byte function2) {
        this.function2 = function2;
    }

    @Basic
    @Column(name = "function3")
    public Byte getFunction3() {
        return function3;
    }

    public void setFunction3(Byte function3) {
        this.function3 = function3;
    }

    @Basic
    @Column(name = "function4")
    public Byte getFunction4() {
        return function4;
    }

    public void setFunction4(Byte function4) {
        this.function4 = function4;
    }

    @Basic
    @Column(name = "function5")
    public Byte getFunction5() {
        return function5;
    }

    public void setFunction5(Byte function5) {
        this.function5 = function5;
    }

    @Basic
    @Column(name = "function6")
    public Byte getFunction6() {
        return function6;
    }

    public void setFunction6(Byte function6) {
        this.function6 = function6;
    }

    @Basic
    @Column(name = "function7")
    public Byte getFunction7() {
        return function7;
    }

    public void setFunction7(Byte function7) {
        this.function7 = function7;
    }

    @Basic
    @Column(name = "function8")
    public Byte getFunction8() {
        return function8;
    }

    public void setFunction8(Byte function8) {
        this.function8 = function8;
    }

    @Basic
    @Column(name = "function9")
    public Byte getFunction9() {
        return function9;
    }

    public void setFunction9(Byte function9) {
        this.function9 = function9;
    }

    @Basic
    @Column(name = "function10")
    public Byte getFunction10() {
        return function10;
    }

    public void setFunction10(Byte function10) {
        this.function10 = function10;
    }

    @Basic
    @Column(name = "function11")
    public Byte getFunction11() {
        return function11;
    }

    public void setFunction11(Byte function11) {
        this.function11 = function11;
    }

    @Basic
    @Column(name = "function12")
    public Byte getFunction12() {
        return function12;
    }

    public void setFunction12(Byte function12) {
        this.function12 = function12;
    }

    @Basic
    @Column(name = "function13")
    public Byte getFunction13() {
        return function13;
    }

    public void setFunction13(Byte function13) {
        this.function13 = function13;
    }

    @Basic
    @Column(name = "function14")
    public Byte getFunction14() {
        return function14;
    }

    public void setFunction14(Byte function14) {
        this.function14 = function14;
    }

    @Basic
    @Column(name = "function15")
    public Byte getFunction15() {
        return function15;
    }

    public void setFunction15(Byte function15) {
        this.function15 = function15;
    }

    @Basic
    @Column(name = "function16")
    public Byte getFunction16() {
        return function16;
    }

    public void setFunction16(Byte function16) {
        this.function16 = function16;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        com.bnuz.entity.dto.ActivityDto that = (com.bnuz.entity.dto.ActivityDto) o;

        if (startTime != that.startTime) return false;
        if (endTime != that.endTime) return false;
        if (memberMaxCount != that.memberMaxCount) return false;
        if (acid != null ? !acid.equals(that.acid) : that.acid != null) return false;
        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (recommed != null ? !recommed.equals(that.recommed) : that.recommed != null) return false;
        if (locateLimit != null ? !locateLimit.equals(that.locateLimit) : that.locateLimit != null) return false;
        if (locateLimitDistance != null ? !locateLimitDistance.equals(that.locateLimitDistance) : that.locateLimitDistance != null)
            return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (limitRater != null ? !limitRater.equals(that.limitRater) : that.limitRater != null) return false;
        if (limitNote != null ? !limitNote.equals(that.limitNote) : that.limitNote != null) return false;
        if (limitShowNickName != null ? !limitShowNickName.equals(that.limitShowNickName) : that.limitShowNickName != null)
            return false;
        if (limitCallover != null ? !limitCallover.equals(that.limitCallover) : that.limitCallover != null)
            return false;
        if (raterCode != null ? !raterCode.equals(that.raterCode) : that.raterCode != null) return false;
        if (raterQrCode != null ? !raterQrCode.equals(that.raterQrCode) : that.raterQrCode != null) return false;
        if (performerCode != null ? !performerCode.equals(that.performerCode) : that.performerCode != null)
            return false;
        if (performerQrCode != null ? !performerQrCode.equals(that.performerQrCode) : that.performerQrCode != null)
            return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (isRegister != null ? !isRegister.equals(that.isRegister) : that.isRegister != null) return false;
        if (memberCount != null ? !memberCount.equals(that.memberCount) : that.memberCount != null) return false;
        if (informations != null ? !informations.equals(that.informations) : that.informations != null) return false;
        if (activityCode != null ? !activityCode.equals(that.activityCode) : that.activityCode != null) return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (wechatQrCode != null ? !wechatQrCode.equals(that.wechatQrCode) : that.wechatQrCode != null) return false;
        if (wechatPublicNumber != null ? !wechatPublicNumber.equals(that.wechatPublicNumber) : that.wechatPublicNumber != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (isDispersed != null ? !isDispersed.equals(that.isDispersed) : that.isDispersed != null) return false;
        if (dispersedIp != null ? !dispersedIp.equals(that.dispersedIp) : that.dispersedIp != null) return false;
        if (function1 != null ? !function1.equals(that.function1) : that.function1 != null) return false;
        if (function2 != null ? !function2.equals(that.function2) : that.function2 != null) return false;
        if (function3 != null ? !function3.equals(that.function3) : that.function3 != null) return false;
        if (function4 != null ? !function4.equals(that.function4) : that.function4 != null) return false;
        if (function5 != null ? !function5.equals(that.function5) : that.function5 != null) return false;
        if (function6 != null ? !function6.equals(that.function6) : that.function6 != null) return false;
        if (function7 != null ? !function7.equals(that.function7) : that.function7 != null) return false;
        if (function8 != null ? !function8.equals(that.function8) : that.function8 != null) return false;
        if (function9 != null ? !function9.equals(that.function9) : that.function9 != null) return false;
        if (function10 != null ? !function10.equals(that.function10) : that.function10 != null) return false;
        if (function11 != null ? !function11.equals(that.function11) : that.function11 != null) return false;
        if (function12 != null ? !function12.equals(that.function12) : that.function12 != null) return false;
        if (function13 != null ? !function13.equals(that.function13) : that.function13 != null) return false;
        if (function14 != null ? !function14.equals(that.function14) : that.function14 != null) return false;
        if (function15 != null ? !function15.equals(that.function15) : that.function15 != null) return false;
        if (function16 != null ? !function16.equals(that.function16) : that.function16 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = acid != null ? acid.hashCode() : 0;
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + memberMaxCount;
        result = 31 * result + (recommed != null ? recommed.hashCode() : 0);
        result = 31 * result + (locateLimit != null ? locateLimit.hashCode() : 0);
        result = 31 * result + (locateLimitDistance != null ? locateLimitDistance.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (limitRater != null ? limitRater.hashCode() : 0);
        result = 31 * result + (limitNote != null ? limitNote.hashCode() : 0);
        result = 31 * result + (limitShowNickName != null ? limitShowNickName.hashCode() : 0);
        result = 31 * result + (limitCallover != null ? limitCallover.hashCode() : 0);
        result = 31 * result + (raterCode != null ? raterCode.hashCode() : 0);
        result = 31 * result + (raterQrCode != null ? raterQrCode.hashCode() : 0);
        result = 31 * result + (performerCode != null ? performerCode.hashCode() : 0);
        result = 31 * result + (performerQrCode != null ? performerQrCode.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (isRegister != null ? isRegister.hashCode() : 0);
        result = 31 * result + (memberCount != null ? memberCount.hashCode() : 0);
        result = 31 * result + (informations != null ? informations.hashCode() : 0);
        result = 31 * result + (activityCode != null ? activityCode.hashCode() : 0);
        result = 31 * result + (qrCode != null ? qrCode.hashCode() : 0);
        result = 31 * result + (wechatQrCode != null ? wechatQrCode.hashCode() : 0);
        result = 31 * result + (wechatPublicNumber != null ? wechatPublicNumber.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (isDispersed != null ? isDispersed.hashCode() : 0);
        result = 31 * result + (dispersedIp != null ? dispersedIp.hashCode() : 0);
        result = 31 * result + (function1 != null ? function1.hashCode() : 0);
        result = 31 * result + (function2 != null ? function2.hashCode() : 0);
        result = 31 * result + (function3 != null ? function3.hashCode() : 0);
        result = 31 * result + (function4 != null ? function4.hashCode() : 0);
        result = 31 * result + (function5 != null ? function5.hashCode() : 0);
        result = 31 * result + (function6 != null ? function6.hashCode() : 0);
        result = 31 * result + (function7 != null ? function7.hashCode() : 0);
        result = 31 * result + (function8 != null ? function8.hashCode() : 0);
        result = 31 * result + (function9 != null ? function9.hashCode() : 0);
        result = 31 * result + (function10 != null ? function10.hashCode() : 0);
        result = 31 * result + (function11 != null ? function11.hashCode() : 0);
        result = 31 * result + (function12 != null ? function12.hashCode() : 0);
        result = 31 * result + (function13 != null ? function13.hashCode() : 0);
        result = 31 * result + (function14 != null ? function14.hashCode() : 0);
        result = 31 * result + (function15 != null ? function15.hashCode() : 0);
        result = 31 * result + (function16 != null ? function16.hashCode() : 0);
        return result;
    }
}
