package com.bnuz.commons.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by QuanQqqqq on 2018/4/2.
 * 对http请求的结果进行封装
 */
@ApiModel(value = "操作结果")
public class Result {

    public static Result Success = success(null);

    public static Result False = fail("接口未实现", ErrorCode.INTERFACE_NOT_FINISH);

    @ApiModelProperty(value = "结果说明 true = 成功  false = 失败  ", allowableValues = "true,false", required = true)//参数说明  参数肯定会存在
    private boolean status;

    @ApiModelProperty("提示信息")
    private String message;

    @ApiModelProperty("错误信息")
    private String errorMsg;

    @ApiModelProperty("错误代码")
    private int errorCode;

    @ApiModelProperty("操作返回的数据结果")
    private Object data;

    //通用结果返回
    public Result(boolean status) {
        this.status = status;
    }

    //成功快捷构造
    public static Result success(final Object data){
        return new Result(true, "获取信息成功", data);
    }

    public static Result success(final Object data, String message) {
        return new Result(true, message, data);
    }

    public static Result success(String message){
        return new Result(true, message);
    }

    //失败快捷构造
    public static Result fail(String errorMsg, int errorCode){
        return new Result(false, errorMsg, errorCode);
    }

    public static Result fail(String errorMsg, int errorCode, Object data) {
        return new Result(false, errorMsg, errorCode, data);
    }
    //

    public Result(boolean status, String errorMsg, int errorCode) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    //获取数据成功返回数据
    public Result(boolean status, Object data) {
        this.status = status;
        this.data = data;
    }

    // 获取数据成功返回数据和信息
    public Result(boolean status, String message, Object data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    //操作成功构造函数
    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    // 操作失败构造函数
    public Result(boolean status, String errorMsg, int errorCode, Object data) {
        this.status = status;
        this.data = data;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "{" +
                " 'status' : " + status +
                ", 'message' : '" + message + '\'' +
                ", 'errorMsg' : '" + errorMsg + '\'' +
                ", 'errorCode' : " + errorCode +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}