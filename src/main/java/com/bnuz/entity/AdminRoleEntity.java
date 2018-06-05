package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_admin_role", schema = "hdzt")
public class AdminRoleEntity {
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @Basic
    @Column(name = "role_name")
    private String roleName;

    @Basic
    @Column(name = "role_cat")
    private String roleCat;
    @Basic
    @Column(name = "status")
    private Byte status;

    @Basic
    @Column(name = "description")
    private String description;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(String roleCat) {
        this.roleCat = roleCat;
    }


    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminRoleEntity that = (AdminRoleEntity) o;

        if (roleId != that.roleId) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (roleCat != null ? !roleCat.equals(that.roleCat) : that.roleCat != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

}