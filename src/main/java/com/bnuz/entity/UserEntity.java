package com.bnuz.entity;

import com.bnuz.utils.serializer.CustomDateSerializer;
import com.bnuz.utils.serializer.StringIgnoreSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class UserEntity {

    @ApiModelProperty("uuid")
    private String uid;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户的所属状态，1=学生，3=就业人员，5=其他，默认为5")
    private short status;

    @ApiModelProperty("邮箱email是否给验证，0=未验证，1=验证，默认为0")
    private Byte emailStatus;

    @ApiModelProperty("是否有头像，0=未上传，1=已上传，默认为0")
    private Byte iconStatus;

    @ApiModelProperty("是否实名认证，0=未认证，3=正在认证，5=未通过认证，7=已认证，默认为0")
    private Short checkStatus;

    @ApiModelProperty("对应outfit（机构）下的所属组的id，如果为0则代表没有所属机构，")
    private String groupId;

    @ApiModelProperty("是否有机构绑定，0=无，1=有")
    private Byte hasOutfit;

    @ApiModelProperty("入驻机构审核状态，0=未提交审核，3=待审核，5=审核失败，7=审核成功，入驻机构")
    private Short outfitStatus;

    @ApiModelProperty("注册时间，用毫秒表示")
    private Long registerTime;

    @ApiModelProperty("qqId")
    private String qqId;

    @ApiModelProperty("wechatId")
    private String wechatId;

    @ApiModelProperty("qqOpenid")
    private String qqOpenid;

    @ApiModelProperty("wechatOpenid")
    private String wechatOpenid;

    @ApiModelProperty("身份证号")
    private String identification;

    @ApiModelProperty("身份证正面")
    private String identifyFaceCard;

    @ApiModelProperty("身份证背面")
    private String identifyBackCard;

    @ApiModelProperty("真名")
    private String realName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("用户的邮箱")
    private String email;

    @ApiModelProperty("性别，0=女，1=男，默认为1")
    private Byte sex;

    @ApiModelProperty("用户头像")
    private String userIcon;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("上一次登录的ip")
    private String lastIp;

    @ApiModelProperty("上一次登录的时间")
    private Long lastLoginTime;

    @ApiModelProperty("所属城市id")
    private Long cityId;

    @ApiModelProperty("账号所拥有货币")
    private Long money;

    @ApiModelProperty("用户状态是否可用，0=不可用，1=可用，默认为1")
    private Byte isFrozen;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Byte getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Byte emailStatus) {
        this.emailStatus = emailStatus;
    }

    public Byte getIconStatus() {
        return iconStatus;
    }

    public void setIconStatus(Byte iconStatus) {
        this.iconStatus = iconStatus;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Byte getHasOutfit() {
        return hasOutfit;
    }

    public void setHasOutfit(Byte hasOutfit) {
        this.hasOutfit = hasOutfit;
    }

    public Short getOutfitStatus() {
        return outfitStatus;
    }

    public void setOutfitStatus(Short outfitStatus) {
        this.outfitStatus = outfitStatus;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
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

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentifyFaceCard() {
        return identifyFaceCard;
    }

    public void setIdentifyFaceCard(String identifyFaceCard) {
        this.identifyFaceCard = identifyFaceCard;
    }

    public String getIdentifyBackCard() {
        return identifyBackCard;
    }

    public void setIdentifyBackCard(String identifyBackCard) {
        this.identifyBackCard = identifyBackCard;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (status != that.status) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (emailStatus != null ? !emailStatus.equals(that.emailStatus) : that.emailStatus != null) return false;
        if (iconStatus != null ? !iconStatus.equals(that.iconStatus) : that.iconStatus != null) return false;
        if (checkStatus != null ? !checkStatus.equals(that.checkStatus) : that.checkStatus != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (hasOutfit != null ? !hasOutfit.equals(that.hasOutfit) : that.hasOutfit != null) return false;
        if (outfitStatus != null ? !outfitStatus.equals(that.outfitStatus) : that.outfitStatus != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (qqId != null ? !qqId.equals(that.qqId) : that.qqId != null) return false;
        if (wechatId != null ? !wechatId.equals(that.wechatId) : that.wechatId != null) return false;
        if (qqOpenid != null ? !qqOpenid.equals(that.qqOpenid) : that.qqOpenid != null) return false;
        if (wechatOpenid != null ? !wechatOpenid.equals(that.wechatOpenid) : that.wechatOpenid != null) return false;
        if (identification != null ? !identification.equals(that.identification) : that.identification != null)
            return false;
        if (identifyFaceCard != null ? !identifyFaceCard.equals(that.identifyFaceCard) : that.identifyFaceCard != null)
            return false;
        if (identifyBackCard != null ? !identifyBackCard.equals(that.identifyBackCard) : that.identifyBackCard != null)
            return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (userIcon != null ? !userIcon.equals(that.userIcon) : that.userIcon != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", emailStatus=" + emailStatus +
                ", iconStatus=" + iconStatus +
                ", checkStatus=" + checkStatus +
                ", groupId='" + groupId + '\'' +
                ", hasOutfit=" + hasOutfit +
                ", outfitStatus=" + outfitStatus +
                ", registerTime=" + registerTime +
                ", qqId='" + qqId + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", qqOpenid='" + qqOpenid + '\'' +
                ", wechatOpenid='" + wechatOpenid + '\'' +
                ", identification='" + identification + '\'' +
                ", identifyFaceCard='" + identifyFaceCard + '\'' +
                ", identifyBackCard='" + identifyBackCard + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", userIcon='" + userIcon + '\'' +
                ", nickName='" + nickName + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", cityId=" + cityId +
                ", money=" + money +
                ", isFrozen=" + isFrozen +
                '}';
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (emailStatus != null ? emailStatus.hashCode() : 0);
        result = 31 * result + (iconStatus != null ? iconStatus.hashCode() : 0);
        result = 31 * result + (checkStatus != null ? checkStatus.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (hasOutfit != null ? hasOutfit.hashCode() : 0);
        result = 31 * result + (outfitStatus != null ? outfitStatus.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (qqId != null ? qqId.hashCode() : 0);
        result = 31 * result + (wechatId != null ? wechatId.hashCode() : 0);
        result = 31 * result + (qqOpenid != null ? qqOpenid.hashCode() : 0);
        result = 31 * result + (wechatOpenid != null ? wechatOpenid.hashCode() : 0);
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (identifyFaceCard != null ? identifyFaceCard.hashCode() : 0);
        result = 31 * result + (identifyBackCard != null ? identifyBackCard.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (userIcon != null ? userIcon.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        return result;
    }
}