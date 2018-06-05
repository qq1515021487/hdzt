package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_rater_operation", schema = "hdzt")
public class ActivityRaterOperationEntity {
    private String roid;
    private String asid;
    private String name;
    private Byte isAttendent;
    private String apid;
    private Long createTime;
    private Long editTime;
    private Long sorted;

    @Id
    @Column(name = "roid")
    public String getRoid() {
        return roid;
    }

    public void setRoid(String roid) {
        this.roid = roid;
    }

    @Basic
    @Column(name = "asid")
    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_attendent")
    public Byte getIsAttendent() {
        return isAttendent;
    }

    public void setIsAttendent(Byte isAttendent) {
        this.isAttendent = isAttendent;
    }

    @Basic
    @Column(name = "apid")
    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
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

        ActivityRaterOperationEntity that = (ActivityRaterOperationEntity) o;

        if (roid != null ? !roid.equals(that.roid) : that.roid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (isAttendent != null ? !isAttendent.equals(that.isAttendent) : that.isAttendent != null) return false;
        if (apid != null ? !apid.equals(that.apid) : that.apid != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roid != null ? roid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isAttendent != null ? isAttendent.hashCode() : 0);
        result = 31 * result + (apid != null ? apid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (sorted != null ? sorted.hashCode() : 0);
        return result;
    }
}