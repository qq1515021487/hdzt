package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_rater_point_table", schema = "hdzt")
public class ActivityRaterPointTableEntity {
    private String rpid;
    private Double point;
    private String rid;
    private String roid;
    private String otid;
    private String comment;
    private Long createTime;

    @Id
    @Column(name = "rpid")
    public String getRpid() {
        return rpid;
    }

    public void setRpid(String rpid) {
        this.rpid = rpid;
    }

    @Basic
    @Column(name = "point")
    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Basic
    @Column(name = "rid")
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "roid")
    public String getRoid() {
        return roid;
    }

    public void setRoid(String roid) {
        this.roid = roid;
    }

    @Basic
    @Column(name = "otid")
    public String getOtid() {
        return otid;
    }

    public void setOtid(String otid) {
        this.otid = otid;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityRaterPointTableEntity that = (ActivityRaterPointTableEntity) o;

        if (rpid != null ? !rpid.equals(that.rpid) : that.rpid != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rpid != null ? rpid.hashCode() : 0;
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}