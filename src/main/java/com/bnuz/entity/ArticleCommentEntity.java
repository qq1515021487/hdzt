package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_article_comment", schema = "hdzt")
public class ArticleCommentEntity {
    private String comid;
    private String content;
    private Long commentDate;
    private Long goodSum;
    private Long badSum;
    private String uid;
    private Long articleId;

    @Id
    @Column(name = "comid")
    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
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
    @Column(name = "comment_date")
    public Long getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Long commentDate) {
        this.commentDate = commentDate;
    }

    @Basic
    @Column(name = "good_sum")
    public Long getGoodSum() {
        return goodSum;
    }

    public void setGoodSum(Long goodSum) {
        this.goodSum = goodSum;
    }

    @Basic
    @Column(name = "bad_sum")
    public Long getBadSum() {
        return badSum;
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

    public void setBadSum(Long badSum) {
        this.badSum = badSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCommentEntity that = (ArticleCommentEntity) o;

        if (comid != null ? !comid.equals(that.comid) : that.comid != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;
        if (goodSum != null ? !goodSum.equals(that.goodSum) : that.goodSum != null) return false;
        if (badSum != null ? !badSum.equals(that.badSum) : that.badSum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comid != null ? comid.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (goodSum != null ? goodSum.hashCode() : 0);
        result = 31 * result + (badSum != null ? badSum.hashCode() : 0);
        return result;
    }
}