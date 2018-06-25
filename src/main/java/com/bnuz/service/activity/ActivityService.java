package com.bnuz.service.activity;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;
import com.bnuz.entity.dto.ActivityDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ActivityService extends BaseService<ActivityDto, String> {

    Result findByUidPage(String uid, PageRequest pageRequest) throws Exception;

    Result joinActivityByCode(String activityCode) throws Exception;

    Result createActivity(ActivityDto activityDto, String uid) throws Exception;

    Result updateActivityByUser(ActivityDto activityDto, String uid) throws Exception;

    Result deleteActivityByAcid(String acid, String uid) throws Exception;

    /**
     * 根据acid获取活动详情
     * @param acid
     * @return
     */
    Result getActivityByAcid(String acid) throws Exception;

    /**
     * 用户进入活动
     * @param attendentId
     * @param acid
     * @param longitude
     * @param latitude
     * @return
     */
    Result userJoinActivity(String attendentId, String acid, double longitude, double latitude, String nickName, String photo) throws Exception;

    Result userJoinActivityByCallOverCode(String code, String acid, String attendentId, String nickName, String name, String photo) throws Exception;

    ActivityAttendentDto joinActivityByAttendentId(String acid, ActivityAttendentInfoDto activityAttendentInfoDto, String nickName, String photo) throws Exception;

    Result getActivityCallOverListByUid(String uid, String acid) throws Exception;

    ActivityDto checkActivityBelongToUser(String uid, String acid) throws Exception;

    /**
     * 将用户信息加入对应活动的redis中，方便查询
     * @param activityAttendentDto
     */
    void addAttendentToRedis(ActivityAttendentDto activityAttendentDto) throws Exception;

    /***
     * 将用户部分信息加入对应活动的redis 列表中，方便查询
     * @param activityAttendentDto
     */
    void addAttendentToRedisActivityList(ActivityAttendentDto activityAttendentDto) throws Exception;
}