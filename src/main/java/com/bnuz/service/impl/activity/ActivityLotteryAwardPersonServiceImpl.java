package com.bnuz.service.impl.activity;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.ActivityLotteryPeopleEntity;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.entity.dto.ActivityLotteryDto;
import com.bnuz.entity.dto.ActivityLotteryPeopleDto;
import com.bnuz.entity.vo.ActivityLotteryPeopleVo;
import com.bnuz.factory.DozerFactory;
import com.bnuz.repository.ActivityLotteryPeoleRepository;
import com.bnuz.service.activity.ActivityLotteryAwardPersonService;
import com.bnuz.service.activity.ActivityLotteryService;
import com.bnuz.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ActivityLotteryAwardPersonService")
public class ActivityLotteryAwardPersonServiceImpl extends BaseServiceImpl<ActivityLotteryPeopleDto, String>
        implements ActivityLotteryAwardPersonService {

    @Autowired
    private ActivityLotteryPeoleRepository activityLotteryPeoleRepository;

    @Autowired
    private ActivityLotteryService activityLotteryService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private DozerFactory dozerFactory;

    @Override
    public BaseRepository<ActivityLotteryPeopleDto, String> getRepository() {
        return activityLotteryPeoleRepository;
    }

    @Override
    public Result getAwardWinningPersonListByType(String uid, String alid, PageRequest pageRequest) {
        try {
            ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
            if (activityLotteryDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            return Result.success(dozerFactory.convert(
                    activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAlidOrderByGainTimeDesc(alid, pageRequest),
                    ActivityLotteryPeopleVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出了一点小意外", ErrorCode.BAD_REQUEST);
        }
    }

    @Override
    public Result getAwardWinningPersonListByActivity(String uid, String acid, PageRequest pageRequest) {
        try {
            ActivityDto activityDto = activityService.checkActivityBelongToUser(uid, acid);
            if (activityDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            return Result.success(dozerFactory.convert(
                    activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAcidOrderByGainTimeDesc(acid, pageRequest),
                    ActivityLotteryPeopleVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出了一点小意外", ErrorCode.BAD_REQUEST);
        }
    }

    @Override
    public Result getAttendentUserAwardListByPrid(String prid, PageRequest pageRequest) {
        try {
            return Result.success(dozerFactory.convert(
                    activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByPridOrderByGainTimeDesc(prid),
                    ActivityLotteryPeopleVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出了一点小意外", ErrorCode.BAD_REQUEST);
        }
    }

    @Override
    public Result getAttendentUserAwardList(String attendentId, PageRequest pageRequest) {
        try {
            return Result.success(dozerFactory.convert(
                    activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAttendentIdOrderByGainTimeDesc(attendentId),
                    ActivityLotteryPeopleVo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出了一点小意外", ErrorCode.BAD_REQUEST);
        }
    }

    @Override
    public Result drawLotteryListByType(String uid, String alid) {
        try {
            ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
            if (activityLotteryDto == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public Result changeLotteryByByType(String uid, String alid, List<String> prizePridList) {
        return null;
    }

    @Override
    public Result comfirmAwardWinningPersonList(String uid, String alid, List<String> list) {
        return null;
    }

    @Override
    public void addTemporaryAwardPersonList(String acid, List<ActivityLotteryPeopleDto> list) {

    }

    @Override
    public void removeTemporaryAwardPerson(String prid) {

    }
}
