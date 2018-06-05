package com.bnuz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_activity_vote_user", schema = "hdzt")
public class ActivityVoteUserEntity {
    private String vuid;
    private String prid;
    private String ovid;
    private String avid;

    @Column(name = "prid")
    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }
    @Column(name = "ovid")
    public String getOvid() {
        return ovid;
    }

    public void setOvid(String ovid) {
        this.ovid = ovid;
    }
    @Column(name = "avid")
    public String getAvid() {
        return avid;
    }

    public void setAvid(String avid) {
        this.avid = avid;
    }

    @Id
    @Column(name = "vuid")
    public String getVuid() {
        return vuid;
    }

    public void setVuid(String vuid) {
        this.vuid = vuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityVoteUserEntity that = (ActivityVoteUserEntity) o;

        if (vuid != null ? !vuid.equals(that.vuid) : that.vuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return vuid != null ? vuid.hashCode() : 0;
    }
}