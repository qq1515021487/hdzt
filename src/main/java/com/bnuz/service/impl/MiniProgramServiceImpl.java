package com.bnuz.service.impl;

import com.bnuz.commons.entity.WechatMiniProgram;
import com.bnuz.service.MiniProgramService;
import com.bnuz.utils.HttpUtil;
import com.bnuz.utils.Utils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class MiniProgramServiceImpl implements MiniProgramService {

    @Override
    public String getAcessToken() {
        try {
            StringBuffer requestUrl = new StringBuffer(WechatMiniProgram.GET_MINI_PROGRAM_ACCESS_TOKEN);
            requestUrl.append(WechatMiniProgram.APP_ID_NAME + "=" +  WechatMiniProgram.APP_ID + "&");
            requestUrl.append(WechatMiniProgram.APP_SECRET_NAME + "=" + WechatMiniProgram.APP_SECRET + "&");
            String result = HttpUtil.get(requestUrl.toString(), null, null, HttpUtil.TYPE_FORM);
            JSONObject jsonObject = JSONObject.fromObject(result);
            if (jsonObject.has(WechatMiniProgram.APP_ACCESS_TOKEN_NAME)) {
                return (String) jsonObject.get(WechatMiniProgram.APP_ACCESS_TOKEN_NAME);
            } else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String getMiniProgramActivityQRCode(String accessToken, String acid) {
        try {
            // 编写参数
            StringBuffer requestUrl = new StringBuffer(WechatMiniProgram.GET_MINI_PROGRAM_QR_CODE_IMG);
            requestUrl.append(WechatMiniProgram.APP_ACCESS_TOKEN_NAME + "=" + accessToken);
            Map<String, String> map = new HashMap<String, String>();
            map.put("scene", acid);
//            map.put("page", WechatMiniProgram.MINI_PROGRAM_ACTIVITY_PAGE);

            // 新建文件
            String storageUrl = WechatMiniProgram.STORAGE_URL + "\\" + Utils.getUUID32() + ".jpg";
            File file = new File(storageUrl);
            if (HttpUtil.getFile(requestUrl.toString(), map, file, HttpUtil.TYPE_JSON)) {
                return storageUrl;
            } else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}