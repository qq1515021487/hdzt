package com.bnuz.controller.activity;

import com.bnuz.commons.entity.HttpContentType;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.service.activity.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/activity")
@Api(description = "活动")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // --------------活动管理者------------------

    @ApiOperation(value = "通过活动创建者token获取活动分页", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/getActivityListByUserOrderPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户Token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "当前页面ID，从0开始", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    public Result getActivityListByUserOrderPage(@RequestHeader("Authorization") String token,
                                                 @RequestParam("page") int page,
                                                 @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.findByUidPage(uid, new PageRequest(page, pageSize));
    }


    @ApiOperation(value = "通过活动创建者获取活动分页，后台使用，拦截器限制", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/getActivityListByUidOrderByPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页面ID，从0开始", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面内容大小", dataType = "int", paramType = "query")
    })
    public Result getActivityListByUidOrderByPage(@RequestParam("uid") String uid,
                                                  @RequestParam("page") int page,
                                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return activityService.findByUidPage(uid, new PageRequest(page, pageSize));
    }

    @ApiOperation(value = "活动创建者创建活动", consumes = HttpContentType.POST_JSON)
    @PostMapping("/createActivity")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "activityEntity", value = "活动实体，用json的格式传输")
    })
    public Result createActivity(@RequestBody ActivityDto activityDto,
                                 @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.createActivity(activityDto, uid);
    }

    @ApiOperation(value = "活动创建者创修改活动", consumes = HttpContentType.POST_JSON)
    @PutMapping("/updateActivityByUser")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "int", paramType = "header"),
            @ApiImplicitParam(name = "activityEntity", value = "活动实体，用json的格式传输")
    })
    public Result updateActivityByUser(@RequestBody ActivityDto activityDto,
                                       @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.updateActivityByUser(activityDto, uid);
    }

    @ApiOperation(value = "活动创建者创删除活动", consumes = HttpContentType.POST_JSON)
    @DeleteMapping("/deleteActivityByAcid")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "int", paramType = "header"),
            @ApiImplicitParam(name = "acid", value = "活动ID", paramType = "query", dataType = "String")
    })
    public Result updateActivityByUser(@RequestParam("acid") String acid,
                                       @RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.deleteActivityByAcid(acid, uid);
    }

    @ApiOperation(value = "活动创建者获取某个活动的签到名单", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/getActivityCallOverList")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", value = "用户的token，在header上", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "acid", value = "活动id", dataType = "String", paramType = "query")
    })
    public Result getActivityCallOverList(@RequestHeader("Authorization") String token,
                                          @RequestParam("acid") String acid) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.getActivityCallOverListByUid(uid, acid);
    }

    // --------------活动参与用户------------------

    @ApiOperation(value = "通过活动6位验证码获取活动", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/joinActivityByCode")
    @ApiImplicitParam(name = "activityCode", value = "活动6位验证码", dataType = "String", paramType = "query")
    public Result joinActivityByCode(@RequestParam("activityCode") String activityCode,
                                     @RequestParam("wechatOpenId") String wechatOpenId) {
        return Result.False;
//        return activityService.joinActivityByCode(activityCode);
    }

    @ApiOperation(value = "用户通过token加入活动", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/userJoinActivity")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "acid", value = "活动id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "longitude", value = "用户所在经度，暂时可以传0", dataType = "Double", paramType = "query"),
            @ApiImplicitParam(name = "latitude", value = "用户所在纬度，暂时可以传0", dataType = "Double", paramType = "query"),
            @ApiImplicitParam(name = "nickName", value = "微信昵称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "photo", value = "微信头像", dataType = "String", paramType = "query")
    })
    public Result userJoinActivity(@RequestHeader("Authorization") String token,
                                   @RequestParam("acid") String acid,
                                   @RequestParam("longitude") double longitude,
                                   @RequestParam("latitude") double latitude,
                                   @RequestParam("nickName") String nickName,
                                   @RequestParam("photo") String photo) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.userJoinActivity(attendentId, acid, longitude, latitude, nickName, photo);
    }

    /**
     * 这里要注意的是：签到名字+签到校验码一定是唯一的，在录入数据的时候需要检测
     * @param token
     * @param code
     * @param acid
     * @param nickName
     * @param photo
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "用户通过活动签到码进入活动", consumes = HttpContentType.GET_FORM_DATA)
    @GetMapping("/userJoinActivityByCallOverCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token", dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "acid", value = "活动id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "用户的校验码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "nickName", value = "微信昵称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "photo", value = "微信头像", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "需要签到的名字", dataType = "String", paramType = "query")
    })
    public Result userJoinActivityByCallOverCode(@RequestHeader("Authorization") String token,
                                                 @RequestParam("code") String code,
                                                 @RequestParam("acid") String acid,
                                                 @RequestParam("nickName") String nickName,
                                                 @RequestParam("photo") String photo,
                                                 @RequestParam("realName") String realName) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        return activityService.userJoinActivityByCallOverCode(code, acid, attendentId, nickName, realName, photo);
    }
}