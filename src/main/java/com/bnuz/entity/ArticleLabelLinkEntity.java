package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_article_label_link", schema = "hdzt")
public class ArticleLabelLinkEntity {
    private Long allid;
    private Long labelId;
    private Long articleId;

    @Id
    @Column(name = "allid")
    public Long getAllid() {
        return allid;
    }

    public void setAllid(Long allid) {
        this.allid = allid;
    }

    @Basic
    @Column(name = "label_id")
    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long lableId) {
        this.labelId = lableId;
    }

    @Basic
    @Column(name = "article_id")
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleLabelLinkEntity that = (ArticleLabelLinkEntity) o;

        if (allid != that.allid) return false;

        return true;
    }
}