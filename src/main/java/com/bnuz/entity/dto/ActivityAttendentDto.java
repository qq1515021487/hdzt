package com.bnuz.entity.dto;

import com.bnuz.entity.ActivityLotteryPeopleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "t_activity_attendent", schema = "hdzt")
public class ActivityAttendentDto {

    @ApiModelProperty("参与者ID")
    @Id
    @Column(name = "prid")
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

    // 奖项获取
    @OneToMany
    @JoinColumn(name = "prid")
    @JsonIgnore
    private List<ActivityLotteryPeopleDto> attendentRewardEntities;

    public List<ActivityLotteryPeopleDto> getAttendentRewardEntities() {
        return attendentRewardEntities;
    }

    public void setAttendentRewardEntities(List<ActivityLotteryPeopleDto> attendentRewardEntities) {
        this.attendentRewardEntities = attendentRewardEntities;
    }


    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    @Basic
    @Column(name = "acid")
    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    @Basic
    @Column(name = "attendent_id")
    public String getAttendentId() {
        return attendentId;
    }

    public void setAttendentId(String attendentId) {
        this.attendentId = attendentId;
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
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "wechat_name")
    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    @Basic
    @Column(name = "login_time")
    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
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
    @Column(name = "operate_time")
    public Long getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Long operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "is_ban")
    public Byte getIsBan() {
        return isBan;
    }

    public void setIsBan(Byte isBan) {
        this.isBan = isBan;
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