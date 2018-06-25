package com.bnuz.service.impl.activity;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.constant.SystemConstant;
import com.bnuz.commons.entity.RedisPropName;
import com.bnuz.commons.entity.WechatMiniProgram;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityAttendentInfoEntity;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;
import com.bnuz.repository.ActivityAttendentInfoRepository;
import com.bnuz.repository.ActivityAttendentRepository;
import com.bnuz.service.MessageService;
import com.bnuz.service.RedisService;
import com.bnuz.service.activity.ActivityAttendentService;
import com.bnuz.utils.HttpUtil;
import com.bnuz.utils.Utils;
import net.sf.json.JSONObject;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.RescaleOp;
import java.util.Date;

@Component("ActivityAttendentService")
public class ActivityAttendentServiceImpl extends BaseServiceImpl<ActivityAttendentDto, String>
        implements ActivityAttendentService {

    @Autowired
    private ActivityAttendentRepository activityAttendentRepository;

    @Autowired
    private ActivityAttendentInfoRepository activityAttendentInfoRepository;

    @Autowired
    private RedisService redisService;

    @Override
    public BaseRepository<ActivityAttendentDto, String> getRepository() {
        return activityAttendentRepository;
    }

    /**
     * 通过微信小程序给的code获取微信信息
     * @param code
     * @return
     */
    @Override
    public Result loginByMiniProgram(String code, String ip) throws Exception {
        // 请求微信获取wechatOpenId和sessionId
        StringBuffer requestUrl = new StringBuffer(WechatMiniProgram.GET_WECHAT_OPEN_ID_LOGIN_URL);
        requestUrl.append(WechatMiniProgram.APP_ID_NAME + "=" +  WechatMiniProgram.APP_ID + "&");
        requestUrl.append(WechatMiniProgram.APP_SECRET_NAME + "=" + WechatMiniProgram.APP_SECRET + "&");
        requestUrl.append(WechatMiniProgram.APP_JS_CODE_NAME + "=" + code + "&");
        requestUrl.append(WechatMiniProgram.APP_GRANT_TYPE_NAME + "=" + WechatMiniProgram.APP_GRANT_TYPE_VALUE);

        // 获取信息转json
        String miniProgramResult = HttpUtil.get(requestUrl.toString(), null, null, HttpUtil.TYPE_FORM);
        JSONObject jsonObject = JSONObject.fromObject(miniProgramResult);

        // 判断微信请求是否有错误
        if (jsonObject.has("errcode")) {
            return Result.fail("获取微信参数异常", ErrorCode.METHOD_NOT_ALLOWED);
        }

        // 微信openId，通过OpenId获取用户uuid信息
        String wechatOpenId = jsonObject.getString("openid");
        ActivityAttendentInfoDto activityAttendentInfoDto = activityAttendentInfoRepository.findByWechatOpenid(wechatOpenId);

        // 如果不存在账号
        if (activityAttendentInfoDto == null) {
            activityAttendentInfoDto = register(wechatOpenId);
        }

        // 更新登录时间
        activityAttendentInfoDto.setLastLoginTime(Utils.getNowSecondTime());
        activityAttendentInfoDto.setLastIp(ip);
        activityAttendentInfoRepository.save(activityAttendentInfoDto);

        // 这个sessionId暂时没有用，以后存到redis里再进行操作
        String sessionId = jsonObject.getString("session_key");
        redisService.set(RedisPropName.ACTIVITY_ATTENDANT_WECHAT_SESSIONID + activityAttendentInfoDto.getAttendentId(), sessionId);

        // 生成一个token返回前端
        return Result.success(JwtUtils.createJWT("attendant", activityAttendentInfoDto.getAttendentId(), SystemConstant.JWT_TTL), "登录成功");
    }



    /**
     * 通过wechatOpenId注册一个游客账号
     * @param wechatOpenId
     * @return
     */
    @Override
    public ActivityAttendentInfoDto register(String wechatOpenId) throws Exception {
        ActivityAttendentInfoDto activityAttendentInfoDto = new ActivityAttendentInfoDto();
        activityAttendentInfoDto.setWechatOpenid(wechatOpenId);
        activityAttendentInfoDto.setAttendentId(Utils.getUUID32());
        activityAttendentInfoDto.setMoney(0L);
        activityAttendentInfoDto.setIsFrozen((byte) 1);
        activityAttendentInfoDto.setUserIcon(null);
        activityAttendentInfoDto.setQqOpenid(null);
        activityAttendentInfoDto.setCityId(0L);
        activityAttendentInfoDto.setSex((byte) 0);
        activityAttendentInfoDto.setEmail(null);
        activityAttendentInfoDto.setTel(null);
        activityAttendentInfoDto.setQqId(null);
        activityAttendentInfoDto.setWechatId(null);
        activityAttendentInfoDto.setIdentification(null);
        return activityAttendentInfoDto;
    }

    @Override
    public ActivityAttendentInfoDto getAttendentInfoByAttendentId(String attendentId) throws Exception {
        return activityAttendentInfoRepository.findByAttendentId(attendentId);
    }

    @Override
    public Result updateAttendentInfo(String attendentId, ActivityAttendentInfoDto activityAttendentInfoDto) throws Exception {
        ActivityAttendentInfoDto correctInfo = activityAttendentInfoRepository.findByAttendentId(attendentId);
        if (attendentId == null || !attendentId.equals(correctInfo.getAttendentId())) {
            return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
        }
        String[] ignoreAttr = {"wechatOpenid", "attendentId", "isFrozen", "money",
                                "lastLoginTime", "lastIp"};
        BeanUtils.copyProperties(activityAttendentInfoDto, correctInfo, ignoreAttr);
        activityAttendentInfoRepository.save(correctInfo);
        return Result.success(correctInfo, "修改个人信息成功");
    }

}