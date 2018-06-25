package com.bnuz.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.service.MessageService;
import com.bnuz.utils.Utils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class MessageServiceImpl implements MessageService {

    // 阿里大鱼密钥
    private final static String ACCESS_KEY_ID_TEL_MESSAGE = "LTAI7zLU6jvngR82";

    // 阿里大鱼密码
    private final static String ACCESS_KEY_SECRET_MESSAGE = "jDr5OeIwaLzr1EUyTPyA5VIVrOIt03";

    // 自己的秘钥
    private final static String KEY = "bnuzpmvv";

    @Override
    public Result sendMessageByTel(String tel) throws Exception {
        try {
            //设置超时时间-可自行调整
            // 设置超时时间为1000 * 60 * 5，5分钟
            System.setProperty("sun.net.client.defaultConnectTimeout", "300000");
            System.setProperty("sun.net.client.defaultReadTimeout", "300000");
            //初始化ascClient需要的几个参数
            final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
            final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
            //替换成你的AK
            final String accessKeyId = ACCESS_KEY_ID_TEL_MESSAGE;//你的accessKeyId,参考本文档步骤2
            final String accessKeySecret = ACCESS_KEY_SECRET_MESSAGE;//你的accessKeySecret，参考本文档步骤2
            //初始化ascClient,暂时不支持多region（请勿修改）
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                    accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(tel);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("活动总台");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_133006589");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            String randomNum = String.valueOf(new Random().nextInt(899999) + 100000);
            request.setTemplateParam("{\"code\":\""+ randomNum + "\"}");
            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                Map<String, Object> map = new HashMap<>();
                // 通过验证码和手机号加密的id
                map.put("sessionid", messageEncode(tel + randomNum));
                // 生成截止时间
                SimpleDateFormat sf = new SimpleDateFormat(Utils.DATE_FORMAT_SIMPLE);
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MINUTE, 5);
                String currentTime = sf.format(c.getTime());
                map.put("tamp", currentTime);
                return Result.success(map);
            } else {
                return Result.fail("短信发送失败", ErrorCode.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("连接阿里大鱼短信失败", ErrorCode.BAD_REQUEST);
        }
    }

    public static String messageDecode(String s) {
        return "hhh，MD5没得解密。。";
    }

    public static String messageEncode(String s) {
        return DigestUtils.md5Hex(s + "@" + KEY);
    }
}