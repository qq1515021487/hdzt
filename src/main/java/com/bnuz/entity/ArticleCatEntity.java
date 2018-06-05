package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_article_cat", schema = "hdzt")
public class ArticleCatEntity {
    private Long catId;
    private Byte catType;
    private String keywords;
    private String catDesc;
    private Byte sorted;
    private Byte showInNav;
    private Long createTime;
    private Long editTime;
    private String editAuid;
    private String catName;

    @Id
    @Column(name = "cat_id")
    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "cat_type")
    public Byte getCatType() {
        return catType;
    }

    public void setCatType(Byte catType) {
        this.catType = catType;
    }

    @Basic
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "cat_desc")
    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    @Basic
    @Column(name = "sorted")
    public Byte getSorted() {
        return sorted;
    }

    public void setSorted(Byte sorted) {
        this.sorted = sorted;
    }

    @Basic
    @Column(name = "show_in_nav")
    public Byte getShowInNav() {
        return showInNav;
    }

    public void setShowInNav(Byte showInNav) {
        this.showInNav = showInNav;
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
    @Column(name = "edit_time")
    public Long getEditTime() {
        return editTime;
    }

    public void setEditTime(Long editTime) {
        this.editTime = editTime;
    }

    @Basic
    @Column(name = "edit_auid")
    public String getEditAuid() {
        return editAuid;
    }

    public void setEditAuid(String editAuid) {
        this.editAuid = editAuid;
    }

    @Basic
    @Column(name = "cat_name")
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCatEntity that = (ArticleCatEntity) o;

        if (catId != that.catId) return false;
        if (catType != that.catType) return false;
        if (sorted != that.sorted) return false;
        if (showInNav != that.showInNav) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (catDesc != null ? !catDesc.equals(that.catDesc) : that.catDesc != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (catName != null ? !catName.equals(that.catName) : that.catName != null) return false;

        return true;
    }

}