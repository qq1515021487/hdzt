package com.bnuz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

public class ActivityEntity {

    @ApiModelProperty("活动表uuid")
    private String acid;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动简介")
    private String description;

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

    @ApiModelProperty("活动状态，1=试用中，3=正式发布，5=结束")
    private int activityStatus;


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

    @Override
    public String toString() {
        return "ActivityEntity{" +
                "acid='" + acid + '\'' +
                ", activityName='" + activityName + '\'' +
                ", description='" + description + '\'' +
                ", cityId=" + cityId +
                ", uid='" + uid + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", memberMaxCount=" + memberMaxCount +
                ", recommed=" + recommed +
                ", locateLimit=" + locateLimit +
                ", locateLimitDistance=" + locateLimitDistance +
                ", lastUpdateTime=" + lastUpdateTime +
                ", content='" + content + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", limitRater=" + limitRater +
                ", limitNote=" + limitNote +
                ", limitShowNickName=" + limitShowNickName +
                ", limitCallover=" + limitCallover +
                ", raterCode='" + raterCode + '\'' +
                ", raterQrCode='" + raterQrCode + '\'' +
                ", performerCode='" + performerCode + '\'' +
                ", performerQrCode='" + performerQrCode + '\'' +
                ", isFrozen=" + isFrozen +
                ", isRegister=" + isRegister +
                ", memberCount=" + memberCount +
                ", informations=" + informations +
                ", activityCode='" + activityCode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", wechatQrCode='" + wechatQrCode + '\'' +
                ", wechatPublicNumber='" + wechatPublicNumber + '\'' +
                ", createTime=" + createTime +
                ", isDispersed=" + isDispersed +
                ", dispersedIp='" + dispersedIp + '\'' +
                ", activityStatus=" + activityStatus +
                ", function1=" + function1 +
                ", function2=" + function2 +
                ", function3=" + function3 +
                ", function4=" + function4 +
                ", function5=" + function5 +
                ", function6=" + function6 +
                ", function7=" + function7 +
                ", function8=" + function8 +
                ", function9=" + function9 +
                ", function10=" + function10 +
                ", function11=" + function11 +
                ", function12=" + function12 +
                ", function13=" + function13 +
                ", function14=" + function14 +
                ", function15=" + function15 +
                ", function16=" + function16 +
                '}';
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getMemberMaxCount() {
        return memberMaxCount;
    }

    public void setMemberMaxCount(int memberMaxCount) {
        this.memberMaxCount = memberMaxCount;
    }

    public Byte getRecommed() {
        return recommed;
    }

    public void setRecommed(Byte recommed) {
        this.recommed = recommed;
    }

    public Byte getLocateLimit() {
        return locateLimit;
    }

    public void setLocateLimit(Byte locateLimit) {
        this.locateLimit = locateLimit;
    }

    public Long getLocateLimitDistance() {
        return locateLimitDistance;
    }

    public void setLocateLimitDistance(Long locateLimitDistance) {
        this.locateLimitDistance = locateLimitDistance;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Byte getLimitRater() {
        return limitRater;
    }

    public void setLimitRater(Byte limitRater) {
        this.limitRater = limitRater;
    }

    public Byte getLimitNote() {
        return limitNote;
    }

    public void setLimitNote(Byte limitNote) {
        this.limitNote = limitNote;
    }

    public Byte getLimitShowNickName() {
        return limitShowNickName;
    }

    public void setLimitShowNickName(Byte limitShowNickName) {
        this.limitShowNickName = limitShowNickName;
    }

    public Byte getLimitCallover() {
        return limitCallover;
    }

    public void setLimitCallover(Byte limitCallover) {
        this.limitCallover = limitCallover;
    }

    public String getRaterCode() {
        return raterCode;
    }

    public void setRaterCode(String raterCode) {
        this.raterCode = raterCode;
    }

    public String getRaterQrCode() {
        return raterQrCode;
    }

    public void setRaterQrCode(String raterQrCode) {
        this.raterQrCode = raterQrCode;
    }

    public String getPerformerCode() {
        return performerCode;
    }

    public void setPerformerCode(String performerCode) {
        this.performerCode = performerCode;
    }

    public String getPerformerQrCode() {
        return performerQrCode;
    }

    public void setPerformerQrCode(String performerQrCode) {
        this.performerQrCode = performerQrCode;
    }

    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Byte getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Byte isRegister) {
        this.isRegister = isRegister;
    }

    public Long getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Long memberCount) {
        this.memberCount = memberCount;
    }

    public Long getInformations() {
        return informations;
    }

    public void setInformations(Long informations) {
        this.informations = informations;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getWechatQrCode() {
        return wechatQrCode;
    }

    public void setWechatQrCode(String wechatQrCode) {
        this.wechatQrCode = wechatQrCode;
    }

    public String getWechatPublicNumber() {
        return wechatPublicNumber;
    }

    public void setWechatPublicNumber(String wechatPublicNumber) {
        this.wechatPublicNumber = wechatPublicNumber;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDispersed() {
        return isDispersed;
    }

    public void setIsDispersed(Byte isDispersed) {
        this.isDispersed = isDispersed;
    }

    public String getDispersedIp() {
        return dispersedIp;
    }

    public void setDispersedIp(String dispersedIp) {
        this.dispersedIp = dispersedIp;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Byte getFunction1() {
        return function1;
    }

    public void setFunction1(Byte function1) {
        this.function1 = function1;
    }

    public Byte getFunction2() {
        return function2;
    }

    public void setFunction2(Byte function2) {
        this.function2 = function2;
    }

    public Byte getFunction3() {
        return function3;
    }

    public void setFunction3(Byte function3) {
        this.function3 = function3;
    }

    public Byte getFunction4() {
        return function4;
    }

    public void setFunction4(Byte function4) {
        this.function4 = function4;
    }

    public Byte getFunction5() {
        return function5;
    }

    public void setFunction5(Byte function5) {
        this.function5 = function5;
    }

    public Byte getFunction6() {
        return function6;
    }

    public void setFunction6(Byte function6) {
        this.function6 = function6;
    }

    public Byte getFunction7() {
        return function7;
    }

    public void setFunction7(Byte function7) {
        this.function7 = function7;
    }

    public Byte getFunction8() {
        return function8;
    }

    public void setFunction8(Byte function8) {
        this.function8 = function8;
    }

    public Byte getFunction9() {
        return function9;
    }

    public void setFunction9(Byte function9) {
        this.function9 = function9;
    }

    public Byte getFunction10() {
        return function10;
    }

    public void setFunction10(Byte function10) {
        this.function10 = function10;
    }

    public Byte getFunction11() {
        return function11;
    }

    public void setFunction11(Byte function11) {
        this.function11 = function11;
    }

    public Byte getFunction12() {
        return function12;
    }

    public void setFunction12(Byte function12) {
        this.function12 = function12;
    }

    public Byte getFunction13() {
        return function13;
    }

    public void setFunction13(Byte function13) {
        this.function13 = function13;
    }

    public Byte getFunction14() {
        return function14;
    }

    public void setFunction14(Byte function14) {
        this.function14 = function14;
    }

    public Byte getFunction15() {
        return function15;
    }

    public void setFunction15(Byte function15) {
        this.function15 = function15;
    }

    public Byte getFunction16() {
        return function16;
    }

    public void setFunction16(Byte function16) {
        this.function16 = function16;
    }
}