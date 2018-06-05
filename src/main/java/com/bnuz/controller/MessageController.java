package com.bnuz.controller;

import com.bnuz.commons.entity.HttpContentType;
import com.bnuz.commons.result.Result;
import com.bnuz.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@Api(description = "短信")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "发送手机短信", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/sendTelMessage")
    @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query")
    public Result sendTelMessage(@RequestParam("phone") String phone) {
        return messageService.sendMessageByTel(phone);
    }
}