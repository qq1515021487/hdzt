package com.bnuz.service.activity;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityLotteryPeopleEntity;
import com.bnuz.entity.dto.ActivityLotteryPeopleDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ActivityLotteryAwardPersonService extends BaseService<ActivityLotteryPeopleDto, String> {


    /**
     * 根据奖品类型获取获奖人员列表
     * 即为alid不同
     * @param uid
     * @param alid
     * @return
     */
    Result getAwardWinningPersonListByType(String uid, String alid, PageRequest pageRequest) throws Exception;

    /**
     * 根据活动获取获奖人员列表
     * @param uid
     * @param acid
     * @return
     */
    Result getAwardWinningPersonListByActivity(String uid, String acid, PageRequest pageRequest) throws Exception;

    /**
     * 根据活动参与者ID获取获奖信息
     * @param prid
     * @param pageRequest
     * @return
     */
    Result getAttendentUserAwardListByPrid(String prid, PageRequest pageRequest) throws Exception;

    /**
     * 根据attendentId获取个人获奖信息
     * @param attendentId
     * @param acid
     * @param pageRequest
     * @return
     */
    Result getAttendentUserAwardList(String attendentId, PageRequest pageRequest) throws Exception;

    /**
     * 获取有资格获奖的人员名单
     * @param uid
     * @param acid
     * @param alid
     * @return
     */
    List<String> getQualifiedAwardUserList(String uid, String acid, String alid) throws Exception;

    /**
     * 根据规则抽取相应人数
     * @param uid
     * @param alid
     * @return
     */
    Result drawLotteryListByType(String uid, String alid) throws Exception;

    /**
     * 根据规则换一个中奖人员
     * @param uid
     * @param alid
     * @return
     */
    Result changeLotteryByByType(String uid, String alid, List<String> prizePridList) throws Exception;

    /**
     * 确认获奖人员
     * @param uid
     * @param alid
     * @param list 已经中奖的人员prid
     * @return
     */
    Result comfirmAwardWinningPersonList(String uid, String alid, List<String> list) throws Exception;

    /**
     * 将获奖人员加到临时表中，这些人被确认前，不会被再抽到一次
     * @param acid
     * @param list
     */
    void addTemporaryAwardPersonList(String acid, List<ActivityLotteryPeopleDto> list) throws Exception;

    void removeTemporaryAwardPerson(String prid) throws Exception;
}
