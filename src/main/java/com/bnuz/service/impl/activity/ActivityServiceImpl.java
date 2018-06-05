package com.bnuz.service.impl.activity;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.entity.RedisKeys;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.*;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;
import com.bnuz.entity.dto.ActivityCallOverDto;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.entity.vo.ActivityAttendentVo;
import com.bnuz.entity.vo.ActivityVo;
import com.bnuz.factory.DozerFactory;
import com.bnuz.repository.ActivityAttendentInfoRepository;
import com.bnuz.repository.ActivityAttendentRepository;
import com.bnuz.repository.ActivityCallOverRepository;
import com.bnuz.repository.ActivityRepository;
import com.bnuz.service.MiniProgramService;
import com.bnuz.service.RedisService;
import com.bnuz.service.activity.ActivityService;
import com.bnuz.utils.Utils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("ActivityService")
public class ActivityServiceImpl extends BaseServiceImpl<ActivityDto, String> implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MiniProgramService miniProgramService;

    @Autowired
    private ActivityAttendentInfoRepository activityAttendentInfoRepository;

    @Autowired
    private ActivityCallOverRepository activityCallOverRepository;

    @Autowired
    private ActivityAttendentRepository activityAttendentRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private DozerFactory dozerFactory;

    @Override
    public BaseRepository<ActivityDto, String> getRepository() {
        return activityRepository;
    }

    /**
     * 通过Uid查找用户申请的活动列表，进行分页
     * @param uid
     * @param pageable
     * @return
     */
    @Override
    public Result findByUidPage(String uid, PageRequest pageRequest) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("data", dozerFactory.convert(
                    activityRepository.findByUidOrderByCreateTimeDesc(uid, pageRequest),
                    ActivityVo.class));
            map.put("count", activityRepository.getActivityCountByUid(uid));
            return Result.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("出现了一点小意外", ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 只用于微信小程序搜索相应码的活动
     * @param activityCode
     * @return
     */
    @Override
    public Result joinActivityByCode(String activityCode) {
        return Result.success(activityRepository.findByActivityCodeAndCreateTimeGreaterThan(activityCode, Utils.getNowSecondTime()));
    }


    /**
     * 创建活动
     * @param activityDto
     * @return
     */
    @Override
    public Result createActivity(ActivityDto activityDto, String uid) {
        ActivityDto correctActivity = new ActivityDto();
        try {
            // 设置参数
            correctActivity.setAcid(Utils.getUUID32());
            correctActivity.setUid(uid);
            correctActivity.setLastUpdateTime(Utils.getNowSecondTime());
            correctActivity.setCreateTime(Utils.getNowSecondTime());
            correctActivity.setActivityStatus(1);
            // 设置城市
            correctActivity.setCityEntity(new CityEntity());
            correctActivity.getCityEntity().setCityId(activityDto.getCityId());
            correctActivity.setDescription(activityDto.getDescription());
            correctActivity.setMemberMaxCount(activityDto.getMemberMaxCount());
            correctActivity.setStartTime(activityDto.getStartTime());
            correctActivity.setEndTime(activityDto.getEndTime());
            correctActivity.setActivityName(activityDto.getActivityName());

            // 获取小程序二维码
            String accessToken = miniProgramService.getAcessToken();
            if (accessToken.equals("error")) {
                return Result.fail("微信获取参数失败", ErrorCode.BAD_REQUEST);
            } else {
                String qrCodeUrl = miniProgramService.getMiniProgramActivityQRCode(accessToken, correctActivity.getAcid());
                if (qrCodeUrl.equals("error")) {
                    return Result.fail("获取小程序二维码失败", ErrorCode.INTERNAL_SERVER_ERROR);
                } else {
                    correctActivity.setQrCode(qrCodeUrl);
                }
            }
            activityRepository.save(correctActivity);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统发生错误", ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return Result.success("创建活动成功");

    }

    @Override
    public Result updateActivityByUser(ActivityDto activityDto, String uid) {
        try {
            ActivityDto correctActivity = activityRepository.findByAcid(activityDto.getAcid());
            if (correctActivity == null) {
                return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
            }
            if (!correctActivity.getUid().equals(uid)) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            correctActivity.setLastUpdateTime(Utils.getNowSecondTime());
            // 设置城市
            correctActivity.setCityEntity(new CityEntity());
            correctActivity.getCityEntity().setCityId(activityDto.getCityId());
            correctActivity.setDescription(activityDto.getDescription());
            correctActivity.setMemberMaxCount(activityDto.getMemberMaxCount());
            correctActivity.setStartTime(activityDto.getStartTime());
            correctActivity.setEndTime(activityDto.getEndTime());
            correctActivity.setActivityName(activityDto.getActivityName());
            activityRepository.save(correctActivity);
            return Result.success(correctActivity, "修改活动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统发生错误", ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Result deleteActivityByAcid(String acid, String uid) {
        try {
            ActivityDto activityDto = activityRepository.findByAcid(acid);
            if (activityDto == null) {
                return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
            }
            if (!activityDto.getUid().equals(uid)) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            activityRepository.delete(acid);
            return Result.success("删除活动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统发生错误", ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public Result getActivityByAcid(String acid) {
        ActivityDto activityDto = activityRepository.findByAcid(acid);
        if (activityDto == null) {
            return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
        } else {
            return Result.success(activityDto, "获取数据成功");
        }
    }

    @Override
    public Result userJoinActivity(String attendentId, String acid, double longitude, double latitude, String nickName, String photo) {
        ActivityDto activityDto = activityRepository.findByAcid(acid);
        if (activityDto == null) {
            return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
        } else {
            // 如果地区限定
            if (activityDto.getLocateLimit() == 1) {
                double distance = Utils.getDistanceByLongitudeAndlatitude(longitude, latitude,
                        activityDto.getLongitude(), activityDto.getLatitude());
                if (distance > activityDto.getLocateLimitDistance()) {
                    return Result.fail("不在区域范围内", ErrorCode.BAD_REQUEST);
                }
            }
            // 查看该用户是否存在
            ActivityAttendentInfoDto activityAttendentInfoDto = activityAttendentInfoRepository.findByAttendentId(attendentId);

            if (activityAttendentInfoDto == null) {
                return Result.fail("不存在账号", ErrorCode.BAD_REQUEST);
            }
                // 如果限定名单
            if (activityDto.getLimitCallover() == 1) {
                // 如果加入的活动需要核验信息，则请前端继续验证
                return Result.fail("请核验信息", ErrorCode.NEED_CONTINUE_OPERATE);
            } else {
                ActivityAttendentDto activityAttendentDto = joinActivityByAttendentId(acid, activityAttendentInfoDto, nickName, photo);
                if (activityAttendentDto == null) {
                    return Result.fail("出现了一点小错误", ErrorCode.BAD_REQUEST);
                }
                Map<String, Object> map = new HashMap<>();
                // vo
                map.put("activityEntity", dozerFactory.convert(activityDto, ActivityVo.class));
                map.put("activityAttendentEntity", dozerFactory.convert(activityAttendentDto, ActivityAttendentVo.class));
                // 这里将来加入成功后需要将这个信息加到redis里

                return Result.success(map, "进入活动成功");
            }
        }
    }

    @Override
    public Result userJoinActivityByCallOverCode(String code, String acid, String attendentId, String nickName, String realName, String photo) {
        // 查看该用户是否存在
        ActivityAttendentInfoDto activityAttendentInfoDto = activityAttendentInfoRepository.findByAttendentId(attendentId);

        if (activityAttendentInfoDto == null) {
            return Result.fail("不存在账号", ErrorCode.BAD_REQUEST);
        }
        ActivityDto activityDto = activityRepository.findByAcid(acid);
        if (activityDto == null) {
            return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
        }

        ActivityCallOverDto activityCallOverDto = activityCallOverRepository.findByAcidAndCallOverCodeAndName(acid, code, realName);
        if (activityCallOverDto == null) {
            return Result.fail("用户签到失败，验证码或验证姓名错误", ErrorCode.BAD_REQUEST);
        }
        ActivityAttendentDto activityAttendentDto = joinActivityByAttendentId(acid, activityAttendentInfoDto, nickName, photo);
        if (activityAttendentDto == null) {
            return Result.fail("出现了一点小错误", ErrorCode.BAD_REQUEST);
        }
        Map<String, Object> map = new HashMap<>();
        // vo
        map.put("activityEntity", dozerFactory.convert(activityDto, ActivityVo.class));
        map.put("activityAttendentEntity", dozerFactory.convert(activityAttendentDto, ActivityAttendentVo.class));
        return Result.success(map, "进入活动成功");
    }


    @Override
    public ActivityAttendentDto joinActivityByAttendentId(String acid,
                                                    ActivityAttendentInfoDto activityAttendentInfoDto,
                                                    String nickName,
                                                    String photo) {
        ActivityAttendentDto activityAttendentDto = null;
        try {
            activityAttendentDto = activityAttendentRepository.findByAttendentIdAndAcid(activityAttendentInfoDto.getAttendentId(), acid);

            // 查看该用户是否有加入过该活动
            if (activityAttendentDto == null) {
                activityAttendentDto = new ActivityAttendentDto();
                activityAttendentDto.setPrid(Utils.getUUID32());
                activityAttendentDto.setWechatOpenid(activityAttendentInfoDto.getWechatOpenid());
                activityAttendentDto.setAttendentId(activityAttendentInfoDto.getAttendentId());
                activityAttendentDto.setNickName(nickName);
                activityAttendentDto.setWechatName(nickName);
                activityAttendentDto.setLoginTime(Utils.getNowSecondTime());
                activityAttendentDto.setOperateTime(Utils.getNowSecondTime());
                activityAttendentDto.setAcid(acid);
                activityAttendentDto.setPhoto(photo);
                activityAttendentRepository.save(activityAttendentDto);
            } else {
                activityAttendentDto.setLoginTime(Utils.getNowSecondTime());
                activityAttendentDto.setOperateTime(Utils.getNowSecondTime());
                activityAttendentRepository.save(activityAttendentDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return activityAttendentDto;
    }

    @Override
    public Result getActivityCallOverListByUid(String uid, String acid) {
        try {
            // 查看该用户是否是该活动管理者
            ActivityDto activityDto = activityRepository.findByAcid(acid);
            if (activityDto == null) {
                return Result.fail("活动不存在", ErrorCode.BAD_REQUEST);
            }
            if (!activityDto.getUid().equals(uid)) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            // 获取需要签到的列表
            List<ActivityCallOverDto> list = activityCallOverRepository.findByAcid(acid);
            int exists = 0;
            for (ActivityCallOverDto activityCallOverDto : list) {
                if (activityCallOverDto.getIsExist() == 1) {
                    exists++;
                }
            }
            Map<String, Object> map = new HashMap<>();
            map.put("signNum", exists);
            map.put("signCount", list.size());
            map.put("signList", list);
            return Result.success(map, "获取数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统出现了一些小错误", ErrorCode.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 判断该活动是否属于该用户
     * @param uid
     * @param acid
     * @return
     */
    @Override
    public ActivityDto checkActivityBelongToUser(String uid, String acid) {
        ActivityDto activityDto = activityRepository.findByAcid(acid);
        if (activityDto == null || uid == null) {
            return null;
        }
        if (!uid.equals(activityDto.getUid())) {
            return null;
        }
        return activityDto;
    }

    @Override
    public void addAttendentToRedis(ActivityAttendentDto activityAttendentDto) {
        if (!redisService.exists(RedisKeys.ACTIVITY_ATTENDANT_KEY + activityAttendentDto.getPrid())) {
            redisService.set(RedisKeys.ACTIVITY_ATTENDANT_KEY + activityAttendentDto.getPrid(), activityAttendentDto);
        }
    }

    @Override
    public void addAttendentToRedisActivityList(ActivityAttendentDto activityAttendentDto) {
        if (redisService.exists(RedisKeys.ACTIVITY_ATTENDANT_LIST_KEY + activityAttendentDto.getAcid())) {
            ActivityAttendentDto vagueAttendant = new ActivityAttendentDto();
            vagueAttendant.setAcid(activityAttendentDto.getAcid());
            vagueAttendant.setPrid(activityAttendentDto.getPrid());
            vagueAttendant.setNickName(activityAttendentDto.getNickName());
            vagueAttendant.setIsBan(activityAttendentDto.getIsBan());
            vagueAttendant.setIsFrozen(activityAttendentDto.getIsFrozen());
            vagueAttendant.setPhoto(activityAttendentDto.getPhoto());
            // 未完成

        }
    }


}