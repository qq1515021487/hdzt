package com.bnuz.commons.result;

/**
 * Created by QuanQqqqq on 2018/4/2.
 * 对http请求状态码封装
 */
public class ErrorCode {

    // 未修改
    public static final int NOT_MODIFIED = 304;

    // 请求出错
    public static final int BAD_REQUEST = 400;

    // 用户没有登录
    public static final int UNAUTHORIZED = 401;

    // 用户没有权限
    public static final int FORBIDDEN = 403;

    // 资源未找到
    public static final int NOT_FOUND = 404;

    // 客户端请求中的方法被禁止
    public static final int METHOD_NOT_ALLOWED = 405;

    // 请求超时
    public static final int REQUEST_OVERTIME = 408;

    // 服务器无法处理请求附带的媒体格式
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;

    // 后台异常
    public static final int INTERNAL_SERVER_ERROR = 500;

    // 请用户继续操作
    public static final int NEED_CONTINUE_OPERATE = 100;

    // 接口未实现
    public static final int INTERFACE_NOT_FINISH = 1000;

    // 参数错误
    public static final int ENTITY_PARAM_ERROR = 1001;
}