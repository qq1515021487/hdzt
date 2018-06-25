package com.bnuz.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "t_activity_attendent_info", schema = "hdzt")
public class ActivityAttendentInfoDto {

    @ApiModelProperty("游客用户的uuid")
    private String attendentId;

    @ApiModelProperty("城市ID")
    private Long cityId;

    @JsonIgnore
    @ApiModelProperty("微信的openid")
    private String wechatOpenid;

    @ApiModelProperty("性别")
    private Byte sex;

    @ApiModelProperty("用户真名")
    private String realName;

    @ApiModelProperty("用户绑定的电话")
    private String tel;

    @Email
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


    @Id
    @Column(name = "attendent_id")
    public String getAttendentId() {
        return attendentId;
    }

    public void setAttendentId(String attendentId) {
        this.attendentId = attendentId;
    }

    @Basic
    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "wechat_openid")
    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "qq_id")
    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    @Basic
    @Column(name = "wechat_id")
    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    @Basic
    @Column(name = "qq_openid")
    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    @Basic
    @Column(name = "identification")
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "user_icon")
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Basic
    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "last_login_time")
    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
    @Column(name = "is_frozen")
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