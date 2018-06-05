package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_article_comment_mark", schema = "hdzt")
public class ArticleCommentMarkEntity {
    private String acmid;
    private String comid;
    private String uid;
    private Byte type;

    @Id
    @Column(name = "acmid")
    public String getAcmid() {
        return acmid;
    }

    public void setAcmid(String acmid) {
        this.acmid = acmid;
    }

    @Basic
    @Column(name = "comid")
    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
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
    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCommentMarkEntity that = (ArticleCommentMarkEntity) o;

        if (acmid != null ? !acmid.equals(that.acmid) : that.acmid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = acmid != null ? acmid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}