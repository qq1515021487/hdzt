package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_rater_assess", schema = "hdzt")
public class ActivityRaterAssessEntity {
    private String asid;
    private String descrition;
    private String background;
    private Long createTime;
    private String otherContent;
    private Byte needOtherContent;
    private Byte isShow;
    private Long optionType;
    private Long maxChoose;
    private Long expirationTime;
    private Long isDouble;
    private Byte isRemark;
    private Double maxPoint;
    private String acid;

    @Id
    @Column(name = "asid")
    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
    }

    @Basic
    @Column(name = "descrition")
    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    @Basic
    @Column(name = "acid")
    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }
    @Basic
    @Column(name = "background")
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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
    @Column(name = "other_content")
    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    @Basic
    @Column(name = "need_other_content")
    public Byte getNeedOtherContent() {
        return needOtherContent;
    }

    public void setNeedOtherContent(Byte needOtherContent) {
        this.needOtherContent = needOtherContent;
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
    @Column(name = "option_type")
    public Long getOptionType() {
        return optionType;
    }

    public void setOptionType(Long optionType) {
        this.optionType = optionType;
    }

    @Basic
    @Column(name = "max_choose")
    public Long getMaxChoose() {
        return maxChoose;
    }

    public void setMaxChoose(Long maxChoose) {
        this.maxChoose = maxChoose;
    }

    @Basic
    @Column(name = "expiration_time")
    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Basic
    @Column(name = "is_double")
    public Long getIsDouble() {
        return isDouble;
    }

    public void setIsDouble(Long isDouble) {
        this.isDouble = isDouble;
    }

    @Basic
    @Column(name = "is_remark")
    public Byte getIsRemark() {
        return isRemark;
    }

    public void setIsRemark(Byte isRemark) {
        this.isRemark = isRemark;
    }

    @Basic
    @Column(name = "max_point")
    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityRaterAssessEntity that = (ActivityRaterAssessEntity) o;

        if (asid != null ? !asid.equals(that.asid) : that.asid != null) return false;
        if (descrition != null ? !descrition.equals(that.descrition) : that.descrition != null) return false;
        if (background != null ? !background.equals(that.background) : that.background != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (otherContent != null ? !otherContent.equals(that.otherContent) : that.otherContent != null) return false;
        if (needOtherContent != null ? !needOtherContent.equals(that.needOtherContent) : that.needOtherContent != null)
            return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;
        if (optionType != null ? !optionType.equals(that.optionType) : that.optionType != null) return false;
        if (maxChoose != null ? !maxChoose.equals(that.maxChoose) : that.maxChoose != null) return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;
        if (isDouble != null ? !isDouble.equals(that.isDouble) : that.isDouble != null) return false;
        if (isRemark != null ? !isRemark.equals(that.isRemark) : that.isRemark != null) return false;
        if (maxPoint != null ? !maxPoint.equals(that.maxPoint) : that.maxPoint != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = asid != null ? asid.hashCode() : 0;
        result = 31 * result + (descrition != null ? descrition.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (otherContent != null ? otherContent.hashCode() : 0);
        result = 31 * result + (needOtherContent != null ? needOtherContent.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (optionType != null ? optionType.hashCode() : 0);
        result = 31 * result + (maxChoose != null ? maxChoose.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (isDouble != null ? isDouble.hashCode() : 0);
        result = 31 * result + (isRemark != null ? isRemark.hashCode() : 0);
        result = 31 * result + (maxPoint != null ? maxPoint.hashCode() : 0);
        return result;
    }
}