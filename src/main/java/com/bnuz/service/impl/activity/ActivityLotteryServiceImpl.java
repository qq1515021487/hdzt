package com.bnuz.service.impl.activity;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityEntity;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.entity.dto.ActivityLotteryDto;
import com.bnuz.repository.ActivityLotteryRepository;
import com.bnuz.service.activity.ActivityLotteryService;
import com.bnuz.service.activity.ActivityService;
import com.bnuz.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component("ActivityLotteryService")
public class ActivityLotteryServiceImpl extends BaseServiceImpl<ActivityLotteryDto, String> implements ActivityLotteryService {

    @Autowired
    private ActivityLotteryRepository activityLotteryRepository;

    @Autowired
    private ActivityService activityService;

    @Override
    public BaseRepository<ActivityLotteryDto, String> getRepository() {
        return activityLotteryRepository;
    }


    @Override
    public Result addActivityLottery(String uid, ActivityLotteryDto activityLotteryDto) {
        ActivityDto activityDto = activityService.checkActivityBelongToUser(uid, activityLotteryDto.getAcid());
        if (activityDto == null) {
            return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
        }
        activityLotteryDto.setAlid(Utils.getUUID32());
        activityLotteryDto.setCreateTime(Utils.getNowSecondTime());
        try {
            activityLotteryRepository.save(activityLotteryDto);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一些小错误", ErrorCode.BAD_REQUEST);
        }
        return Result.success("添加奖品成功");
    }

    @Override
    public Result updateActivityLottery(String uid, ActivityLotteryDto activityLotteryDto) {
        try {
            ActivityLotteryDto lotteryCheckEntity = checkActivityLotteryBelongToUser(uid, activityLotteryDto.getAlid());
            if (lotteryCheckEntity == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            // 无视匹配的参数名
            String ignoreAttr[] = {"alid", "createTime", "acid"};
            BeanUtils.copyProperties(activityLotteryDto, lotteryCheckEntity, ignoreAttr);
            activityLotteryRepository.save(lotteryCheckEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一些小错误", ErrorCode.BAD_REQUEST);
        }

        return Result.success("更新成功");
    }

    @Override
    public Result deleteActivityLottery(String uid, String alid) {
        try {
            ActivityLotteryDto activityLotteryDto = checkActivityLotteryBelongToUser(uid, alid);
            if (activityLotteryDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            activityLotteryRepository.delete(alid);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一些小错误", ErrorCode.BAD_REQUEST);
        }
        return Result.success("删除奖品成功");
    }

    @Override
    public Result findPageListByAcid(String uid, String acid, Pageable pageable) {
        Map<String, Object> map = new HashMap<>();
        try {
            ActivityDto activityDto = activityService.checkActivityBelongToUser(uid, acid);
            if (activityDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一些小错误", ErrorCode.BAD_REQUEST);
        }
        return Result.success(activityLotteryRepository.findByAcidOrderByCreateTimeDesc(acid, pageable), "获取数据成功");
    }

    @Override
    public Result getActivityLotteryByID(String uid, String alid) {
        ActivityLotteryDto activityLotteryDto = null;
        try {
            activityLotteryDto = checkActivityLotteryBelongToUser(uid, alid);
            if (activityLotteryDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一些小错误", ErrorCode.BAD_REQUEST);
        }

        return Result.success(activityLotteryDto, "获取数据成功");
    }

    @Override
    public ActivityLotteryDto checkActivityLotteryBelongToUser(String uid, String alid) throws Exception {
        ActivityLotteryDto activityLotteryDto = activityLotteryRepository.findOne(alid);
        if (activityLotteryDto == null || uid == null) {
            return null;
        }
        ActivityDto activityDto = activityService.checkActivityBelongToUser(uid, activityLotteryDto.getAcid());
        if (activityDto == null) {
            return null;
        }
        return activityLotteryDto;
    }
}
