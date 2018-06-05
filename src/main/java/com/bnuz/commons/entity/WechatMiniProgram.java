package com.bnuz.commons.entity;

public class WechatMiniProgram {

    // 小程序appid与app secret
    public static final String APP_ID = "#";
    public static final String APP_SECRET = "#";

    // 获取wechatOpenId请求地址，需要appid，secret，js_code，grant_type
    public static final String GET_WECHAT_OPEN_ID_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?";

    // 获取7200s的access_token
    public static final String GET_MINI_PROGRAM_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
    public static final String GET_MINI_PROGRAM_QR_CODE_IMG = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?";

    // 参数key
    public static final String APP_GRANT_TYPE_NAME = "grant_type";
    public static final String APP_ID_NAME = "appid";
    public static final String APP_SECRET_NAME = "secret";
    public static final String APP_JS_CODE_NAME = "js_code";
    public static final String APP_ACCESS_TOKEN_NAME = "access_token";

    // 参数val
    public static final String APP_GRANT_TYPE_VALUE = "authorization_code";


    // 微信小程序跳转页面
    public static final String MINI_PROGRAM_ACTIVITY_PAGE = "pages/contact/contact";

    // 小程序图片URL
    public static final String STORAGE_URL = "C:\\Users\\15150\\Desktop";
}
