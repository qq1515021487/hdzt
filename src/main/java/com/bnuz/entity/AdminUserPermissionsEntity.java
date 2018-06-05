package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_admin_user_permissions", schema = "hdzt")
public class AdminUserPermissionsEntity {
    private Long permissionId;
    private String permissionName;
    private Long parent;
    private String url;
    private Byte accordion;
    private String description;

    @Id
    @Column(name = "permission_id")
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "parent")
    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "accordion")
    public Byte getAccordion() {
        return accordion;
    }

    public void setAccordion(Byte accordion) {
        this.accordion = accordion;
    }

    @Basic
    @Column(name = "description")
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

        AdminUserPermissionsEntity that = (AdminUserPermissionsEntity) o;

        if (permissionId != that.permissionId) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (accordion != null ? !accordion.equals(that.accordion) : that.accordion != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

}