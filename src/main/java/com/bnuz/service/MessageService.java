package com.bnuz.service;

import com.bnuz.commons.result.Result;

public interface MessageService {

    // 发送手机短信
    public Result sendMessageByTel(String tel) throws Exception;

}