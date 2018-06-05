package com.bnuz.entity;

import com.bnuz.utils.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_admin_user", schema = "hdzt")
public class AdminUserEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "auid")
    @ApiModelProperty("管理员uuid")
    private String auid;

    @ApiModelProperty("管理员账号")
    private String username;

    @ApiModelProperty("管理员密码")
    private String password;

    @ApiModelProperty("管理员真实姓名")
    private String realName;

    @ApiModelProperty("管理员性别")
    private Byte sex;

    @ApiModelProperty("是否冻结， 0=否，1=是")
    private Byte isFrozen;

    @ApiModelProperty("管理员电话")
    private String tel;

    @Email
    @ApiModelProperty("管理员邮箱")
    private String email;

    @ApiModelProperty("账号描述")
    private String description;

    @ApiModelProperty("账号权限，超级管理员=99，普通管理员=50")
    private Long status;

    @ApiModelProperty("上一次登录的ip")
    private String lastLoginIp;

    @JsonSerialize(using = CustomDateSerializer.class)
    @ApiModelProperty("上一次登录的时间")
    private Long lastLoginTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    @ApiModelProperty("上次操作的时间")
    private Long lastOperateTime;

    @ApiModelProperty("是否有审核机构的权限，有=1，否=0")
    private Byte limitCheckOutfit;

    @ApiModelProperty("是否有接收用户反馈信息的权限，有=1，否=0")
    private Byte limitGetFeedblack;

    @ApiModelProperty("是否有管理机构的权限，有=1，否=0,")
    private Byte limitManageOutfit;

    @ApiModelProperty("是否有管理用户甲的权限，有=1，否=0")
    private Byte limitManageUser;

    @ApiModelProperty("是否有统计信息的权限，有=1，否=0")
    private Byte limitCountAcitiveInfo;

    @ApiModelProperty("是否有发送公告的权限，有=1，否=0")
    private Byte limitSendNotice;

    @ApiModelProperty("是否有管理总站的权限，有=1，否=0")
    private Byte limitManageAllInfo;



    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_admin_user_role", joinColumns = {@JoinColumn(name = "auid")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<AdminRoleEntity> roles;


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
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
    @Column(name = "is_frozen")
    public Byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(Byte isFrozen) {
        this.isFrozen = isFrozen;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status")
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "last_login_ip")
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
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
    @Column(name = "last_operate_time")
    public Long getLastOperateTime() {
        return lastOperateTime;
    }

    public void setLastOperateTime(Long lastOperateTime) {
        this.lastOperateTime = lastOperateTime;
    }

    @Basic
    @Column(name = "limit_check_outfit")
    public Byte getLimitCheckOutfit() {
        return limitCheckOutfit;
    }

    public void setLimitCheckOutfit(Byte limitCheckOutfit) {
        this.limitCheckOutfit = limitCheckOutfit;
    }

    @Basic
    @Column(name = "limit_get_feedblack")
    public Byte getLimitGetFeedblack() {
        return limitGetFeedblack;
    }

    public void setLimitGetFeedblack(Byte limitGetFeedblack) {
        this.limitGetFeedblack = limitGetFeedblack;
    }

    @Basic
    @Column(name = "limit_manage_outfit")
    public Byte getLimitManageOutfit() {
        return limitManageOutfit;
    }

    public void setLimitManageOutfit(Byte limitManageOutfit) {
        this.limitManageOutfit = limitManageOutfit;
    }

    @Basic
    @Column(name = "limit_manage_user")
    public Byte getLimitManageUser() {
        return limitManageUser;
    }

    public void setLimitManageUser(Byte limitManageUser) {
        this.limitManageUser = limitManageUser;
    }

    @Basic
    @Column(name = "limit_count_acitive_info")
    public Byte getLimitCountAcitiveInfo() {
        return limitCountAcitiveInfo;
    }

    public void setLimitCountAcitiveInfo(Byte limitCountAcitiveInfo) {
        this.limitCountAcitiveInfo = limitCountAcitiveInfo;
    }

    @Basic
    @Column(name = "limit_send_notice")
    public Byte getLimitSendNotice() {
        return limitSendNotice;
    }

    public void setLimitSendNotice(Byte limitSendNotice) {
        this.limitSendNotice = limitSendNotice;
    }

    @Basic
    @Column(name = "limit_manage_all_info")
    public Byte getLimitManageAllInfo() {
        return limitManageAllInfo;
    }

    public void setLimitManageAllInfo(Byte limitManageAllInfo) {
        this.limitManageAllInfo = limitManageAllInfo;
    }

    public List<AdminRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminRoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminUserEntity that = (AdminUserEntity) o;

        if (auid != null ? !auid.equals(that.auid) : that.auid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (isFrozen != null ? !isFrozen.equals(that.isFrozen) : that.isFrozen != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(that.lastLoginIp) : that.lastLoginIp != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (lastOperateTime != null ? !lastOperateTime.equals(that.lastOperateTime) : that.lastOperateTime != null)
            return false;
        if (limitCheckOutfit != null ? !limitCheckOutfit.equals(that.limitCheckOutfit) : that.limitCheckOutfit != null)
            return false;
        if (limitGetFeedblack != null ? !limitGetFeedblack.equals(that.limitGetFeedblack) : that.limitGetFeedblack != null)
            return false;
        if (limitManageOutfit != null ? !limitManageOutfit.equals(that.limitManageOutfit) : that.limitManageOutfit != null)
            return false;
        if (limitManageUser != null ? !limitManageUser.equals(that.limitManageUser) : that.limitManageUser != null)
            return false;
        if (limitCountAcitiveInfo != null ? !limitCountAcitiveInfo.equals(that.limitCountAcitiveInfo) : that.limitCountAcitiveInfo != null)
            return false;
        if (limitSendNotice != null ? !limitSendNotice.equals(that.limitSendNotice) : that.limitSendNotice != null)
            return false;
        if (limitManageAllInfo != null ? !limitManageAllInfo.equals(that.limitManageAllInfo) : that.limitManageAllInfo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = auid != null ? auid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (isFrozen != null ? isFrozen.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (lastOperateTime != null ? lastOperateTime.hashCode() : 0);
        result = 31 * result + (limitCheckOutfit != null ? limitCheckOutfit.hashCode() : 0);
        result = 31 * result + (limitGetFeedblack != null ? limitGetFeedblack.hashCode() : 0);
        result = 31 * result + (limitManageOutfit != null ? limitManageOutfit.hashCode() : 0);
        result = 31 * result + (limitManageUser != null ? limitManageUser.hashCode() : 0);
        result = 31 * result + (limitCountAcitiveInfo != null ? limitCountAcitiveInfo.hashCode() : 0);
        result = 31 * result + (limitSendNotice != null ? limitSendNotice.hashCode() : 0);
        result = 31 * result + (limitManageAllInfo != null ? limitManageAllInfo.hashCode() : 0);
        return result;
    }
}