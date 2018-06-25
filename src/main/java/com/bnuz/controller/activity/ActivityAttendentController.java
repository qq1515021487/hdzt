package com.bnuz.controller.activity;

import com.bnuz.commons.entity.HttpContentType;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.ActivityAttendentInfoEntity;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;
import com.bnuz.service.activity.ActivityAttendentService;
import com.bnuz.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/activity/attendent")
@Api(description = "活动参与者")
public class ActivityAttendentController {

    @Autowired
    private ActivityAttendentService activityAttendentService;

    @ApiOperation(value = "通过微信小程序code登录获取uuid", consumes = HttpContentType.POST_FORM_DATA)
    @ApiImplicitParam(name = "code", value = "微信code", required = true, dataType = "String", paramType = "query")
    @PostMapping("/login")
    public Result login(@RequestParam("code") String code, HttpServletRequest request)throws Exception {
        return activityAttendentService.loginByMiniProgram(code, Utils.getIpAddr(request));
    }

    @ApiOperation(value = "通过用户token获取用户信息", consumes = HttpContentType.GET_FORM_DATA)
    @ApiImplicitParam(name = "Authorization", value = "用户token", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAttendentInfoByToken")
    public Result getAttendentInfoByToken(@RequestHeader("Authorization") String token) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        ActivityAttendentInfoDto activityAttendentInfoDto = activityAttendentService.getAttendentInfoByAttendentId(attendentId);
        if (activityAttendentInfoDto == null) {
            return Result.fail("用户不存在", ErrorCode.BAD_REQUEST);
        }
        return Result.success(activityAttendentInfoDto, "返回用户信息成功");
    }

    @ApiOperation(value = "小程序通过token修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户token，参数写在url上", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "activityAttendentInfoDto", value = "用户数据实体", required = true)
    })
    @PostMapping("/updateAttendentInfoByToken")
    public Result updateAttendentInfoByToken(@RequestBody @Validated ActivityAttendentInfoDto activityAttendentInfoDto,
                                             @RequestHeader("Authorization") String token) throws Exception {
        String attendentId = (String) JwtUtils.parseJWT(token).get("sub");
        return activityAttendentService.updateAttendentInfo(attendentId, activityAttendentInfoDto);
    }

}