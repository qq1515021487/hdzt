package com.bnuz.entity.dto;

import com.bnuz.annotation.ExcelResources;

public class ActivityCallOverExcelDto {

    // 需要签到的人名
    private String name;

    // 签到码
    private String callOverCode;

    // 是否签到
    private String isExist;

    public ActivityCallOverExcelDto(String name, String callOverCode, String isExist) {
        this.name = name;
        this.callOverCode = callOverCode;
        this.isExist = isExist;
    }

    @Override
    public String toString() {
        return "ActivityCallOverExcelDto{" +
                "name='" + name + '\'' +
                ", callOverCode='" + callOverCode + '\'' +
                ", isExist='" + isExist + '\'' +
                '}';
    }

    @ExcelResources(title = "签到人员名", order = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ExcelResources(title = "签到码，六位符号", order = 2)
    public String getCallOverCode() {
        return callOverCode;
    }

    public void setCallOverCode(String callOverCode) {
        this.callOverCode = callOverCode;
    }

    @ExcelResources(title = "是否签到，只能填是或否，默认为否，可不填", order = 3)
    public String getIsExist() {
        return isExist;
    }

    public void setIsExist(String isExist) {
        this.isExist = isExist;
    }
}
