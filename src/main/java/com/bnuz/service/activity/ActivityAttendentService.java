package com.bnuz.service.activity;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityAttendentInfoEntity;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;

import javax.servlet.http.HttpServletRequest;

public interface ActivityAttendentService extends BaseService<ActivityAttendentDto, String> {

    Result loginByMiniProgram(String code, String ip) throws Exception;

    ActivityAttendentInfoDto register(String wechatOpenId) throws Exception;

    ActivityAttendentInfoDto getAttendentInfoByAttendentId(String attendentId) throws Exception;

    Result updateAttendentInfo(String attendentId, ActivityAttendentInfoDto activityAttendentInfoDto) throws Exception;

}