package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_admin_operator_log", schema = "hdzt")
public class AdminOperatorLogEntity {
    private Long aolid;
    private String auid;
    private String detail;
    private Long operateTime;

    @Id
    @Column(name = "aolid")
    public Long getAolid() {
        return aolid;
    }

    public void setAolid(Long aolid) {
        this.aolid = aolid;
    }

    @Basic
    @Column(name = "auid")
    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "operate_time")
    public Long getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Long operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminOperatorLogEntity that = (AdminOperatorLogEntity) o;

        if (aolid != that.aolid) return false;
        if (operateTime != that.operateTime) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;

        return true;
    }

}