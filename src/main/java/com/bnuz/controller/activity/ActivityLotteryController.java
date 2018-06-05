package com.bnuz.controller.activity;

import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityLotteryDto;
import com.bnuz.repository.ActivityAttendentRepository;
import com.bnuz.service.activity.ActivityLotteryAwardPersonService;
import com.bnuz.service.activity.ActivityLotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("活动抽奖")
@RequestMapping("/api/activity/lottery")
public class ActivityLotteryController {


    /**
     * 1、获取抽奖人员名单--
     * 2、从excel导入抽奖指定名单--
     * 3、添加抽奖人员名单--
     * 4、更改人员信息--
     * 5、删除人员--
     * 6、分页查--
     * 7、根据id查找指定抽奖人员--
     * 8、添加奖品--
     * 9、删除奖品--
     * 10、获取奖品分页列表--
     * 11、更改奖品--
     * 12、根据奖品ID查找奖品--
     * 13、创建、修改、删除、查找抽奖环节
     *
     *
     * 14、抽奖？
     */

    @Autowired
    private ActivityLotteryService activityLotteryService;

    @Autowired
    private ActivityLotteryAwardPersonService activityLotteryAwardPersonService;

    @Autowired
    private ActivityAttendentRepository activityAttendentRepository;

    /**
     * 根据uid和奖品类别添加奖品
     * @param activityLotteryEntity
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/addActivityLotteryAward")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "activityLotteryEntity", value = "活动奖品实体"),
    })
    @ApiOperation(value = "增加活动奖品")
    public Result addActivityLotteryAward(@RequestBody ActivityLotteryDto activityLotteryDto,
                                          @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryService.addActivityLottery(uid, activityLotteryDto);
    }

    /**
     * 通过奖品ID获取奖品信息
     * @param token
     * @param alid
     * @param acid
     * @return
     * @throws Exception
     */
    @GetMapping("/getActivityLotteryAwardByID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "alid", value = "奖品id", dataType = "String", paramType = "query"),
    })
    @ApiOperation(value = "根据奖品id获取奖品信息")
    public Result getActivityLotteryAwardByID(@RequestHeader("Authorization") String token,
                                              @RequestParam("alid") String alid) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryService.getActivityLotteryByID(uid, alid);
    }

    @PutMapping("/updateActivityLotteryAwardByID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "activityLotteryEntity", value = "活动奖品实体"),
    })
    @ApiOperation(value = "根据奖品id更改奖品信息")
    public Result updateActivityLotteryAwardByID(@RequestBody ActivityLotteryDto activityLotteryDto,
                                                 @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryService.updateActivityLottery(uid, activityLotteryDto);
    }

    /**
     * 根据奖品ID删除奖品
     * @param token
     * @param alid
     * @param acid
     * @return
     * @throws Exception
     */
    @DeleteMapping("/deleteActivityLotteryAwardByID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "alid", value = "奖品id", dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "根据奖品id删除奖品信息")
    public Result deleteActivityLotteryAwardByID(@RequestHeader("Authorization") String token,
                                              @RequestParam("alid") String alid) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryService.deleteActivityLottery(uid, alid);
    }

    /**
     * 根据acid获取活动奖品列表
     * @param token
     * @param acid
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @GetMapping("/getActivityLotteryAwardListPageByAcid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "acid", value = "活动UUID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页面ID", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "根据acid获取活动奖品列表")
    public Result getActivityLotteryAwardListPageByAcid(@RequestHeader("Authorization") String token,
                                         @RequestParam("acid") String acid,
                                         @RequestParam("page") int page,
                                         @RequestParam("pageSize") int pageSize) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryService.findPageListByAcid(uid, acid, new PageRequest(page, pageSize));
    }

    @GetMapping("/getAwardWinningPersonListByType")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "alid", value = "活动奖品类别ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页面ID", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "活动创建者根据奖品类别ID获取奖品列表")
    public Result getAwardWinningPersonListByType(@RequestParam("alid") String alid,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestParam("page") int page,
                                                  @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryAwardPersonService.getAwardWinningPersonListByType(uid, alid, new PageRequest(page, pageSize));
    }

    @GetMapping("/getAwardWinningPersonListByActivity")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "alid", value = "活动奖品类别ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页面ID", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "活动创建者根据活动ID获取奖品列表")
    public Result getAwardWinningPersonListByActivity(@RequestParam("acid") String acid,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestParam("page") int page,
                                                  @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryAwardPersonService.getAwardWinningPersonListByActivity(uid, acid, new PageRequest(page, pageSize));
    }



    // ------- 活动参与者

    @GetMapping("/getAttendentUserAwardListByPrid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "当前页面ID", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "活动创建者根据活动ID获取奖品列表")
    public Result getAttendentUserAwardListByPrid(@RequestParam("pageSize") int pageSize,
                                                      @RequestParam("page") int page,
                                                      @RequestHeader("Authorization") String token) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        ActivityAttendentDto activityAttendentDto = activityAttendentRepository.findByAttendentId(attendentId);
        if (activityAttendentDto == null) {
            return Result.fail("用户不存在", ErrorCode.BAD_REQUEST);
        }
        return activityLotteryAwardPersonService.getAttendentUserAwardListByPrid(activityAttendentDto.getPrid(), new PageRequest(page, pageSize));
    }

    @GetMapping("/getAttendentUserAwardList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "当前页面ID", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "活动创建者根据活动ID获取奖品列表")
    public Result getAttendentUserAwardList(@RequestParam("pageSize") int pageSize,
                                            @RequestParam("page") int page,
                                            @RequestHeader("Authorization") String token) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        return activityLotteryAwardPersonService.getAttendentUserAwardList(attendentId, new PageRequest(page, pageSize));
    }
}
