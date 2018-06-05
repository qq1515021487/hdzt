package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_vote_option", schema = "hdzt")
public class ActivityVoteOptionEntity {
    private String ovid;
    private Long sorted;
    private String name;
    private Long count;
    private String photo;
    private String thumbnail;
    private String avid;

    @Id
    @Column(name = "ovid")
    public String getOvid() {
        return ovid;
    }

    public void setOvid(String ovid) {
        this.ovid = ovid;
    }

    @Basic
    @Column(name = "avid")
    public String getAvid() {
        return avid;
    }

    public void setAvid(String avid) {
        this.avid = avid;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityVoteOptionEntity that = (ActivityVoteOptionEntity) o;

        if (ovid != null ? !ovid.equals(that.ovid) : that.ovid != null) return false;
        if (sorted != null ? !sorted.equals(that.sorted) : that.sorted != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ovid != null ? ovid.hashCode() : 0;
        result = 31 * result + (sorted != null ? sorted.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        return result;
    }
}