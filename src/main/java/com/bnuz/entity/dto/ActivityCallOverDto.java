package com.bnuz.entity.dto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "t_activity_call_over", schema = "hdzt")
public class ActivityCallOverDto {

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

    @Id
    @Column(name = "acoid")
    public String getAcoid() {
        return acoid;
    }

    public void setAcoid(String acoid) {
        this.acoid = acoid;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_exist")
    public Byte getIsExist() {
        return isExist;
    }

    public void setIsExist(Byte isExist) {
        this.isExist = isExist;
    }

    @Basic
    @Column(name = "call_over_code")
    public String getCallOverCode() {
        return callOverCode;
    }

    public void setCallOverCode(String callOverCode) {
        this.callOverCode = callOverCode;
    }

    @Basic
    @Column(name = "prid")
    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
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