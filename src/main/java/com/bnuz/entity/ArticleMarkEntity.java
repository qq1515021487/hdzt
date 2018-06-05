package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_article_mark", schema = "hdzt")
public class ArticleMarkEntity {
    private String amid;
    private String uid;
    private Long articleId;
    private Byte type;

    @Id
    @Column(name = "amid")
    public String getAmid() {
        return amid;
    }

    public void setAmid(String amid) {
        this.amid = amid;
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
    @Column(name = "article_id")
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

        ArticleMarkEntity that = (ArticleMarkEntity) o;

        if (amid != null ? !amid.equals(that.amid) : that.amid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amid != null ? amid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}