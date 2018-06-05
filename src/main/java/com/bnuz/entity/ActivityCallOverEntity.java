package com.bnuz.entity;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

public class ActivityCallOverEntity {

    @ApiModelProperty("点名ID")
    private String acoid;

    @ApiModelProperty("需要签到的名字")
    private String name;

    @ApiModelProperty("活动ID")
    private String acid;

    @ApiModelProperty("是否签到")
    private Byte isExist;

    @ApiModelProperty("签到码")
    private String callOverCode;

    @ApiModelProperty("参与者ID")
    private String prid;


    public String getAcoid() {
        return acoid;
    }

    public void setAcoid(String acoid) {
        this.acoid = acoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public Byte getIsExist() {
        return isExist;
    }

    public void setIsExist(Byte isExist) {
        this.isExist = isExist;
    }

    public String getCallOverCode() {
        return callOverCode;
    }

    public void setCallOverCode(String callOverCode) {
        this.callOverCode = callOverCode;
    }

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityCallOverEntity that = (ActivityCallOverEntity) o;

        if (acoid != null ? !acoid.equals(that.acoid) : that.acoid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (isExist != null ? !isExist.equals(that.isExist) : that.isExist != null) return false;
        if (callOverCode != null ? !callOverCode.equals(that.callOverCode) : that.callOverCode != null) return false;
        if (prid != null ? !prid.equals(that.prid) : that.prid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = acoid != null ? acoid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isExist != null ? isExist.hashCode() : 0);
        result = 31 * result + (callOverCode != null ? callOverCode.hashCode() : 0);
        result = 31 * result + (prid != null ? prid.hashCode() : 0);
        return result;
    }
}