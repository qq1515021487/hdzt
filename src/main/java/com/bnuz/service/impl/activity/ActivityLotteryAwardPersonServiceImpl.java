package com.bnuz.service.impl.activity;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.entity.RedisPropName;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.ActivityLotteryPeopleEntity;
import com.bnuz.entity.dto.*;
import com.bnuz.entity.vo.ActivityLotteryPeopleVo;
import com.bnuz.factory.DozerFactory;
import com.bnuz.repository.ActivityAttendentRepository;
import com.bnuz.repository.ActivityCallOverRepository;
import com.bnuz.repository.ActivityLotteryPeoleRepository;
import com.bnuz.service.RedisService;
import com.bnuz.service.activity.ActivityLotteryAwardPersonService;
import com.bnuz.service.activity.ActivityLotteryService;
import com.bnuz.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

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
    private ActivityAttendentRepository activityAttendentRepository;

    @Autowired
    private ActivityCallOverRepository activityCallOverRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private DozerFactory dozerFactory;

    @Override
    public BaseRepository<ActivityLotteryPeopleDto, String> getRepository() {
        return activityLotteryPeoleRepository;
    }

    @Override
    public Result getAwardWinningPersonListByType(String uid, String alid, PageRequest pageRequest) throws Exception {
        ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
        if (activityLotteryDto == null) {
            return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
        }
        return Result.success(dozerFactory.convert(
                activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAlidOrderByGainTimeDesc(alid, pageRequest),
                ActivityLotteryPeopleVo.class));
    }

    @Override
    public Result getAwardWinningPersonListByActivity(String uid, String acid, PageRequest pageRequest) throws Exception {
        return Result.success(dozerFactory.convert(
                activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAcidOrderByGainTimeDesc(acid, pageRequest),
                ActivityLotteryPeopleVo.class));
    }

    @Override
    public Result getAttendentUserAwardListByPrid(String prid, PageRequest pageRequest) throws Exception {
        return Result.success(dozerFactory.convert(
                activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByPridOrderByGainTimeDesc(prid, pageRequest),
                ActivityLotteryPeopleVo.class));
    }

    @Override
    public Result getAttendentUserAwardList(String attendentId, PageRequest pageRequest) throws Exception {
        return Result.success(dozerFactory.convert(
                activityLotteryPeoleRepository.findActivityLotteryPeopleDtosByAttendentIdOrderByGainTimeDesc(attendentId,
                        pageRequest.getPageNumber(), pageRequest.getPageNumber()),
                ActivityLotteryPeopleVo.class));
    }

    @Override
    public List<String> getQualifiedAwardUserList(String uid, String acid, String alid) throws Exception {
        ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
        // 这里获取信息可以通过redis改进
        List<ActivityAttendentDto> currectList = activityAttendentRepository.findActivityAttendentDtosByAcid(acid);
        // 所有参加活动用户的列表
        Map<String, Boolean> currectAttendantMap = new HashMap<>();
        for (ActivityAttendentDto activityAttendentDto : currectList) {
            currectAttendantMap.put(activityAttendentDto.getPrid(), false);
        }

        // 如果是私有抽奖
        if (activityLotteryDto.getIsCallOver() == 1) {
            List<ActivityCallOverDto> callOverList = activityCallOverRepository.findByAcid(acid);
            // 遍历标记所有可以参与抽奖的人的名单
            for (ActivityCallOverDto activityCallOverDto : callOverList) {
                if (currectAttendantMap.get(activityCallOverDto.getPrid()) != null) {
                    // 如果必须限定消息数发送量
                    if (activityLotteryDto.getLogicType() == 0 &&
                            activityLotteryDto.getLimitSendMessage() == 1) {
                        if (redisService.get(RedisPropName.ACTIVITY_ATTENDANT_SEND_MESSAGE_COUNT
                                + activityCallOverDto.getPrid(), Integer.class)
                                >= activityLotteryDto.getLimitSendMessageCount()) {
                            currectAttendantMap.put(activityCallOverDto.getPrid(), true);
                        }
                    } else {
                        currectAttendantMap.put(activityCallOverDto.getPrid(), true);
                    }
                }
            }
            if (activityLotteryDto.getLogicType() == 1) {
                for (ActivityAttendentDto activityAttendentDto : currectList) {
                    // 如果消息数大于所限定的消息数
                    if (redisService.get(RedisPropName.ACTIVITY_ATTENDANT_SEND_MESSAGE_COUNT
                            + activityAttendentDto.getPrid(), Integer.class)
                            >= activityLotteryDto.getLimitSendMessageCount()) {
                        if (currectAttendantMap.get(activityAttendentDto.getPrid()) != null) {
                            currectAttendantMap.put(activityAttendentDto.getPrid(), true);
                        }
                    }
                }
            }
        } else {
            // 遍历标记所有可以参与抽奖的人的名单
            for (Map.Entry<String, Boolean> item : currectAttendantMap.entrySet()) {
                String attendantPrid = item.getKey();
                Boolean value = item.getValue();
                // 如果必须限定消息数发送量
                if (activityLotteryDto.getLimitSendMessage() == 1) {
                    if (redisService.get(RedisPropName.ACTIVITY_ATTENDANT_SEND_MESSAGE_COUNT
                            + attendantPrid, Integer.class)
                            >= activityLotteryDto.getLimitSendMessageCount()) {
                        currectAttendantMap.put(attendantPrid, true);
                    }
                } else {
                    currectAttendantMap.put(attendantPrid, true);
                }
            }
        }
        // 取出已经抽中的人的名单
        List<String> hasReWardPerson = redisService.getList(
                RedisPropName.ACTIVITY_LOTTERY_PRESON_LIST + activityLotteryDto.getAlid(), String.class);
        for (String prid : hasReWardPerson) {
            if (currectAttendantMap.get(prid) != null) {
                currectAttendantMap.put(prid, false);
            }
        }

        List<String> currectPridList = new ArrayList<>();

        // 获取正确抽奖人员里列表
        for (Iterator<Map.Entry<String, Boolean>> it = currectAttendantMap.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Boolean> item = it.next();
            if (item.getValue()) {
                currectPridList.add(item.getKey());
            }
        }


        return currectPridList;
    }

    @Override
    public Result drawLotteryListByType(String uid, String alid) throws Exception {
        ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
        if (activityLotteryDto == null) {
            return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
        }
        List<String> currectPridList = getQualifiedAwardUserList(uid, activityLotteryDto.getAcid(), alid);
        // 在currectPridList中抽奖
        List<String> awardList = new ArrayList<>();

        // 最大获奖人数
        int maxRewardPersonCount = Math.min(currectPridList.size(),
                Math.min(activityLotteryDto.getNumbers(), activityLotteryDto.getPerson() - activityLotteryDto.getWinners()));
        int size = maxRewardPersonCount;
        Random random = new Random();
        String temp = "";
        while (size > 0) {
            int idx = random.nextInt(size);
            // 获取获奖人员
            awardList.add(currectPridList.get(idx));
            currectPridList.set(idx, currectPridList.get(size - 1));
            size--;
        }

        // 告诉这些人他们获奖了

        return Result.success(currectPridList, "恭喜这" + maxRewardPersonCount + "个用户获奖");
    }

    @Override
    public Result changeLotteryByByType(String uid, String alid, List<String> prizePridList) throws Exception {
        ActivityLotteryDto activityLotteryDto = activityLotteryService.checkActivityLotteryBelongToUser(uid, alid);
        if (activityLotteryDto == null) {
            return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
        }
        // 去除正在被选定的名单
        List currectPridList = getQualifiedAwardUserList(uid, activityLotteryDto.getAcid(), alid);
        Map<String, Boolean> currectMap = new HashMap<>();
        for (String str : prizePridList) {
            currectMap.put(str, true);
        }
        for (Iterator<String> item = currectPridList.iterator(); item.hasNext();) {
            String prid = item.next();
            if (currectMap.get(prid) != null && currectMap.get(prid)) {
                item.remove();
            }
        }
        if (currectPridList.size() == 0) {
            return Result.fail("已经没有可以抽选的人员", ErrorCode.BAD_REQUEST);
        }
        // 随机抽一个
        Random random = new Random();
        int idx = random.nextInt(currectPridList.size());

        // 告诉这个人他被抽中了

        return Result.success(currectPridList.get(idx), "恭喜该用户获奖");
    }

    @Override
    public Result comfirmAwardWinningPersonList(String uid, String alid, List<String> list) throws Exception {
        return null;
    }

    @Override
    public void addTemporaryAwardPersonList(String acid, List<ActivityLotteryPeopleDto> list) throws Exception {

    }

    @Override
    public void removeTemporaryAwardPerson(String prid) throws Exception {

    }
}
