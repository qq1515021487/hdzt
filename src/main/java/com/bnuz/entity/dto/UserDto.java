package com.bnuz.entity.dto;

import com.bnuz.utils.serializer.CustomDateSerializer;
import com.bnuz.utils.serializer.StringIgnoreSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_user", schema = "hdzt")
public class UserDto {

    @ApiModelProperty("uuid")
    private String uid;

    @NotNull
    @ApiModelProperty("用户账号")
    private String username;

    @JsonSerialize(using = StringIgnoreSerializer.class)
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

    @JsonSerialize(using = CustomDateSerializer.class)
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

    @Email
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

    @JsonSerialize(using = CustomDateSerializer.class)
    @ApiModelProperty("上一次登录的时间")
    private Long lastLoginTime;

    @ApiModelProperty("所属城市id")
    private Long cityId;

    @ApiModelProperty("账号所拥有货币")
    private Long money;

    @ApiModelProperty("用户状态是否可用，0=不可用，1=可用，默认为1")
    private Byte isFrozen;

    @Id
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "status")
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Basic
    @Column(name = "email_status")
    public Byte getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Byte emailStatus) {
        this.emailStatus = emailStatus;
    }

    @Basic
    @Column(name = "icon_status")
    public Byte getIconStatus() {
        return iconStatus;
    }

    public void setIconStatus(Byte iconStatus) {
        this.iconStatus = iconStatus;
    }

    @Basic
    @Column(name = "check_status")
    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Basic
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "has_outfit")
    public Byte getHasOutfit() {
        return hasOutfit;
    }

    public void setHasOutfit(Byte hasOutfit) {
        this.hasOutfit = hasOutfit;
    }

    @Basic
    @Column(name = "outfit_status")
    public Short getOutfitStatus() {
        return outfitStatus;
    }

    public void setOutfitStatus(Short outfitStatus) {
        this.outfitStatus = outfitStatus;
    }

    @Basic
    @Column(name = "register_time")
    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
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

    @JsonIgnore
    @Basic
    @Column(name = "qq_openid")
    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    @JsonIgnore
    @Basic
    @Column(name = "wechat_openid")
    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
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
    @Column(name = "identify_face_card")
    public String getIdentifyFaceCard() {
        return identifyFaceCard;
    }

    public void setIdentifyFaceCard(String identifyFaceCard) {
        this.identifyFaceCard = identifyFaceCard;
    }

    @Basic
    @Column(name = "identify_back_card")
    public String getIdentifyBackCard() {
        return identifyBackCard;
    }

    public void setIdentifyBackCard(String identifyBackCard) {
        this.identifyBackCard = identifyBackCard;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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