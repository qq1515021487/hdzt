package com.bnuz.entity.vo;

import com.bnuz.entity.ActivityEntity;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

public class ActivityVo extends ActivityEntity {

    @ApiModelProperty("城市名称")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
