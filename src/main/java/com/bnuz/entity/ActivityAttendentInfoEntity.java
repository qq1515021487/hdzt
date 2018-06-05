package com.bnuz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

public class ActivityAttendentInfoEntity {

    @ApiModelProperty("游客用户的uuid")
    private String attendentId;

    @ApiModelProperty("城市ID")
    private Long cityId;

    @ApiModelProperty("微信的openid")
    private String wechatOpenid;

    @ApiModelProperty("性别")
    private Byte sex;

    @ApiModelProperty("用户真名")
    private String realName;

    @ApiModelProperty("用户绑定的电话")
    private String tel;

    @ApiModelProperty("用户绑定的邮箱")
    private String email;

    @ApiModelProperty("QQ号")
    private String qqId;

    @ApiModelProperty("微信号")
    private String wechatId;

    @ApiModelProperty("qq的openid")
    private String qqOpenid;

    @ApiModelProperty("身份证")
    private String identification;

    @ApiModelProperty("用户头像")
    private String userIcon;

    @ApiModelProperty("上一次登录IP")
    private String lastIp;

    @ApiModelProperty("上一次登录时间")
    private Long lastLoginTime;

    @ApiModelProperty("持有货币")
    private Long money;

    @ApiModelProperty("用户状态")
    private Byte isFrozen;

    public String getAttendentId() {
        return attendentId;
    }

    public void setAttendentId(String attendentId) {
        this.attendentId = attendentId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    @Override
    public String toString() {
        return "ActivityAttendentInfoEntity{" +
                "attendentId='" + attendentId + '\'' +
                ", cityId=" + cityId +
                ", wechatOpenid='" + wechatOpenid + '\'' +
                ", sex=" + sex +
                ", realName='" + realName + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", qqId='" + qqId + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", qqOpenid='" + qqOpenid + '\'' +
                ", identification='" + identification + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", money=" + money +
                ", isFrozen=" + isFrozen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityAttendentInfoEntity that = (ActivityAttendentInfoEntity) o;

        if (attendentId != null ? !attendentId.equals(that.attendentId) : that.attendentId != null) return false;
        if (wechatOpenid != null ? !wechatOpenid.equals(that.wechatOpenid) : that.wechatOpenid != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (qqId != null ? !qqId.equals(that.qqId) : that.qqId != null) return false;
        if (wechatId != null ? !wechatId.equals(that.wechatId) : that.wechatId != null) return false;
        if (qqOpenid != null ? !qqOpenid.equals(that.qqOpenid) : that.qqOpenid != null) return false;
        if (identification != null ? !identification.equals(that.identification) : that.identification != null)
            return false;
        if (userIcon != null ? !userIcon.equals(that.userIcon) : that.userIcon != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attendentId != null ? attendentId.hashCode() : 0;
        result = 31 * result + (wechatOpenid != null ? wechatOpenid.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (qqId != null ? qqId.hashCode() : 0);
        result = 31 * result + (wechatId != null ? wechatId.hashCode() : 0);
        result = 31 * result + (qqOpenid != null ? qqOpenid.hashCode() : 0);
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (userIcon != null ? userIcon.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        return result;
    }
}