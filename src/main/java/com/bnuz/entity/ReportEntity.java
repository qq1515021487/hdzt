package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_report", schema = "hdzt")
public class ReportEntity {
    private String reportId;
    private String uid;
    private String content;
    private Long createTime;
    private Byte isRead;
    private Byte isSolve;
    private Long sorted;

    @Id
    @Column(name = "report_id")
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "is_read")
    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "is_solve")
    public Byte getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(Byte isSolve) {
        this.isSolve = isSolve;
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

        ReportEntity that = (ReportEntity) o;

        if (reportId != null ? !reportId.equals(that.reportId) : that.reportId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (isRead != null ? !isRead.equals(that.isRead) : that.isRead != null) return false;
        if (isSolve != null ? !isSolve.equals(that.isSolve) : that.isSolve != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reportId != null ? reportId.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (isSolve != null ? isSolve.hashCode() : 0);
        result = 31 * result + (sorted != null ? sorted.hashCode() : 0);
        return result;
    }
}