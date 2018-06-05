package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_vote", schema = "hdzt")
public class ActivityVoteEntity {
    private String avid;
    private Long createTime;
    private Byte isRealShow;
    private Short showType;
    private String voteTitle;
    private String acid;
    private String background;
    private Long optionType;
    private Long maxChoice;
    private Long expirationTime;
    private Long voterCount;
    private Long sorted;
    private Byte needShowPhoto;

    @Id
    @Column(name = "avid")
    public String getAvid() {
        return avid;
    }

    public void setAvid(String avid) {
        this.avid = avid;
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
    @Column(name = "is_real_show")
    public Byte getIsRealShow() {
        return isRealShow;
    }

    public void setIsRealShow(Byte isRealShow) {
        this.isRealShow = isRealShow;
    }

    @Basic
    @Column(name = "show_type")
    public Short getShowType() {
        return showType;
    }

    public void setShowType(Short showType) {
        this.showType = showType;
    }

    @Basic
    @Column(name = "vote_title")
    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
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
    @Column(name = "option_type")
    public Long getOptionType() {
        return optionType;
    }

    public void setOptionType(Long optionType) {
        this.optionType = optionType;
    }

    @Basic
    @Column(name = "max_choice")
    public Long getMaxChoice() {
        return maxChoice;
    }

    public void setMaxChoice(Long maxChoice) {
        this.maxChoice = maxChoice;
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
    @Column(name = "voter_count")
    public Long getVoterCount() {
        return voterCount;
    }

    public void setVoterCount(Long voterCount) {
        this.voterCount = voterCount;
    }

    @Basic
    @Column(name = "sorted")
    public Long getSorted() {
        return sorted;
    }

    public void setSorted(Long sorted) {
        this.sorted = sorted;
    }

    @Basic
    @Column(name = "need_show_photo")
    public Byte getNeedShowPhoto() {
        return needShowPhoto;
    }

    public void setNeedShowPhoto(Byte needShowPhoto) {
        this.needShowPhoto = needShowPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityVoteEntity that = (ActivityVoteEntity) o;

        if (avid != null ? !avid.equals(that.avid) : that.avid != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (isRealShow != null ? !isRealShow.equals(that.isRealShow) : that.isRealShow != null) return false;
        if (showType != null ? !showType.equals(that.showType) : that.showType != null) return false;
        if (voteTitle != null ? !voteTitle.equals(that.voteTitle) : that.voteTitle != null) return false;
        if (background != null ? !background.equals(that.background) : that.background != null) return false;
        if (optionType != null ? !optionType.equals(that.optionType) : that.optionType != null) return false;
        if (maxChoice != null ? !maxChoice.equals(that.maxChoice) : that.maxChoice != null) return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;
        if (voterCount != null ? !voterCount.equals(that.voterCount) : that.voterCount != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;
        if (needShowPhoto != null ? !needShowPhoto.equals(that.needShowPhoto) : that.needShowPhoto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = avid != null ? avid.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (isRealShow != null ? isRealShow.hashCode() : 0);
        result = 31 * result + (showType != null ? showType.hashCode() : 0);
        result = 31 * result + (voteTitle != null ? voteTitle.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (optionType != null ? optionType.hashCode() : 0);
        result = 31 * result + (maxChoice != null ? maxChoice.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (voterCount != null ? voterCount.hashCode() : 0);
        result = 31 * result + (sorted != null ? sorted.hashCode() : 0);
        result = 31 * result + (needShowPhoto != null ? needShowPhoto.hashCode() : 0);
        return result;
    }
}