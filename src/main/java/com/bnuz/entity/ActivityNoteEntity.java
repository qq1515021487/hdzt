package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_note", schema = "hdzt")
public class ActivityNoteEntity {
    private String anid;
    private String content;
    private Long sendTime;
    private Byte isShow;
    private String prid;
    private Byte isPaScreen;

    @Id
    @Column(name = "anid")
    public String getAnid() {
        return anid;
    }

    public void setAnid(String anid) {
        this.anid = anid;
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
    @Column(name = "send_time")
    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
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
    @Column(name = "prid")
    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    @Basic
    @Column(name = "is_pa_screen")
    public Byte getIsPaScreen() {
        return isPaScreen;
    }

    public void setIsPaScreen(Byte isPaScreen) {
        this.isPaScreen = isPaScreen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityNoteEntity that = (ActivityNoteEntity) o;

        if (anid != null ? !anid.equals(that.anid) : that.anid != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;
        if (isPaScreen != null ? !isPaScreen.equals(that.isPaScreen) : that.isPaScreen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = anid != null ? anid.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (isPaScreen != null ? isPaScreen.hashCode() : 0);
        return result;
    }
}