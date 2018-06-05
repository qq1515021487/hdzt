package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_admin_notice", schema = "hdzt")
public class AdminNoticeEntity {
    private Long anid;
    private Long createTime;
    private Byte isShow;
    private Long backgroundColor;
    private String detail;
    private String auid;

    @Id
    @Column(name = "anid")
    public Long getAnid() {
        return anid;
    }

    public void setAnid(Long anid) {
        this.anid = anid;
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
    @Column(name = "is_show")
    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "background_color")
    public Long getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Long backgroundColor) {
        this.backgroundColor = backgroundColor;
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
    @Column(name = "auid")
    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminNoticeEntity that = (AdminNoticeEntity) o;

        if (anid != that.anid) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;
        if (backgroundColor != null ? !backgroundColor.equals(that.backgroundColor) : that.backgroundColor != null)
            return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;

        return true;
    }


}