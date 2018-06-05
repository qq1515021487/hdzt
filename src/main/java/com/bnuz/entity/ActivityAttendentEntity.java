package com.bnuz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;


public class ActivityAttendentEntity {

    @ApiModelProperty("参与者ID")
    private String prid;

    @ApiModelProperty("活动ID")
    private String acid;

    @ApiModelProperty("游客用户的uuid")
    private String attendentId;

    @ApiModelProperty("微信openid")
    private String wechatOpenid;

    @ApiModelProperty("昵称，如果签到，则昵称改变")
    private String nickName;

    @ApiModelProperty("微信名")
    private String wechatName;

    @ApiModelProperty("签到时间")
    private Long loginTime;

    @ApiModelProperty("该用户是否给冻结，0=否，1=是，默认为0")
    private Byte isFrozen;

    @ApiModelProperty("操作时间")
    private Long operateTime;

    @ApiModelProperty("微信头像")
    private String photo;

    @ApiModelProperty("是否禁止发言，0=否，1=是，默认为0")
    private Byte isBan;

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public String getAttendentId() {
        return attendentId;
    }

    public void setAttendentId(String attendentId) {
        this.attendentId = attendentId;
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Long getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Long operateTime) {
        this.operateTime = operateTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Byte getIsBan() {
        return isBan;
    }

    public void setIsBan(Byte isBan) {
        this.isBan = isBan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityAttendentEntity that = (ActivityAttendentEntity) o;

        if (prid != null ? !prid.equals(that.prid) : that.prid != null) return false;
        if (wechatOpenid != null ? !wechatOpenid.equals(that.wechatOpenid) : that.wechatOpenid != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (wechatName != null ? !wechatName.equals(that.wechatName) : that.wechatName != null) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (isBan != null ? !isBan.equals(that.isBan) : that.isBan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prid != null ? prid.hashCode() : 0;
        result = 31 * result + (wechatOpenid != null ? wechatOpenid.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (wechatName != null ? wechatName.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (isBan != null ? isBan.hashCode() : 0);
        return result;
    }
}