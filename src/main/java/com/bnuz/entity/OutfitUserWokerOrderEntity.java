package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_outfit_user_woker_order", schema = "hdzt")
public class OutfitUserWokerOrderEntity {
    private String orderId;
    private String uid;
    private String oid;
    private Long createTime;
    private String content;
    private Byte isRead;
    private String report;
    private Byte isOutfitDelete;
    private Byte isAdminDelete;
    private Byte type;
    private Byte isSolve;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    @Column(name = "oid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "report")
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Basic
    @Column(name = "is_outfit_delete")
    public Byte getIsOutfitDelete() {
        return isOutfitDelete;
    }

    public void setIsOutfitDelete(Byte isOutfitDelete) {
        this.isOutfitDelete = isOutfitDelete;
    }

    @Basic
    @Column(name = "is_admin_delete")
    public Byte getIsAdminDelete() {
        return isAdminDelete;
    }

    public void setIsAdminDelete(Byte isAdminDelete) {
        this.isAdminDelete = isAdminDelete;
    }

    @Basic
    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "is_solve")
    public Byte getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(Byte isSolve) {
        this.isSolve = isSolve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutfitUserWokerOrderEntity that = (OutfitUserWokerOrderEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (isRead != null ? !isRead.equals(that.isRead) : that.isRead != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;
        if (isOutfitDelete != null ? !isOutfitDelete.equals(that.isOutfitDelete) : that.isOutfitDelete != null)
            return false;
        if (isAdminDelete != null ? !isAdminDelete.equals(that.isAdminDelete) : that.isAdminDelete != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (isSolve != null ? !isSolve.equals(that.isSolve) : that.isSolve != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (isOutfitDelete != null ? isOutfitDelete.hashCode() : 0);
        result = 31 * result + (isAdminDelete != null ? isAdminDelete.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isSolve != null ? isSolve.hashCode() : 0);
        return result;
    }
}