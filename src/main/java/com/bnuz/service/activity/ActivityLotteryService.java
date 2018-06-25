package com.bnuz.service.activity;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.dto.ActivityLotteryDto;
import org.springframework.data.domain.Pageable;


public interface ActivityLotteryService extends BaseService<ActivityLotteryDto, String> {

    Result addActivityLottery(String uid, ActivityLotteryDto activityLotteryDto) throws Exception;

    Result updateActivityLottery(String uid, ActivityLotteryDto activityLotteryDto) throws Exception;

    Result deleteActivityLottery(String uid, String alid) throws Exception;

    Result findPageListByAcid(String uid, String acid, Pageable pageable) throws Exception;

    Result getActivityLotteryByID(String uid, String alid) throws Exception;

    ActivityLotteryDto checkActivityLotteryBelongToUser(String uid, String alid) throws Exception;
}
