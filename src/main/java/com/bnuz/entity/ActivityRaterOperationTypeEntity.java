package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_rater_operation_type", schema = "hdzt")
public class ActivityRaterOperationTypeEntity {
    private String otid;
    private String asid;
    private String name;
    private Double maxPoint;
    private Double minPoint;
    private Long createTime;
    private Long editTime;
    private Long sorted;

    @Id
    @Column(name = "otid")
    public String getOtid() {
        return otid;
    }

    public void setOtid(String otid) {
        this.otid = otid;
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
    @Column(name = "max_point")
    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Basic
    @Column(name = "min_point")
    public Double getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Double minPoint) {
        this.minPoint = minPoint;
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

        ActivityRaterOperationTypeEntity that = (ActivityRaterOperationTypeEntity) o;

        if (otid != null ? !otid.equals(that.otid) : that.otid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (maxPoint != null ? !maxPoint.equals(that.maxPoint) : that.maxPoint != null) return false;
        if (minPoint != null ? !minPoint.equals(that.minPoint) : that.minPoint != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = otid != null ? otid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (maxPoint != null ? maxPoint.hashCode() : 0);
        result = 31 * result + (minPoint != null ? minPoint.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (sorted != null ? sorted.hashCode() : 0);
        return result;
    }
}