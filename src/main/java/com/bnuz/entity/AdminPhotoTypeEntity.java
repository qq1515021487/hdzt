package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_admin_photo_type", schema = "hdzt")
public class AdminPhotoTypeEntity {
    private Long typeId;
    private String editAuid;
    private String description;
    private Long createTime;
    private Long editTime;
    private Long sorted;

    @Id
    @Column(name = "type_id")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "edit_auid")
    public String getEditAuid() {
        return editAuid;
    }

    public void setEditAuid(String editAuid) {
        this.editAuid = editAuid;
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
    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "edit_time")
    public Long getEditTime() {
        return editTime;
    }

    public void setEditTime(Long editTime) {
        this.editTime = editTime;
    }

    @Basic
    @Column(name = "sorted")
    public Long getSorted() {
        return sorted;
    }

    public void setSorted(Long sorted) {
        this.sorted = sorted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminPhotoTypeEntity that = (AdminPhotoTypeEntity) o;

        if (typeId != that.typeId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;

        return true;
    }

}