package com.bnuz.controller.user;

import com.bnuz.commons.baseController.BaseController;
import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.entity.HttpContentType;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.UserEntity;
import com.bnuz.entity.dto.UserDto;
import com.bnuz.service.impl.MessageServiceImpl;
import com.bnuz.service.user.UserService;
import com.bnuz.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/user")
@Api(description = "用户")
public class UserController extends BaseController<UserDto, String> {
    @Autowired
    private UserService userService;


    @Override
    public BaseService<UserDto, String> getService() {
        return userService;
    }

    @ApiOperation(value = "活动创建者用户登录", consumes = HttpContentType.POST_FORM_DATA)
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query")
    })
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        return userService.login(username, password);
    }

    @ApiOperation(value = "活动创建者用户注册", consumes = HttpContentType.POST_JSON)
    @PostMapping(value = "/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDto", value = "用户实体"),
            @ApiImplicitParam(name = "code", value = "验证码", paramType = "query"),
            @ApiImplicitParam(name = "tamp", value = "过期时间", paramType = "query"),
            @ApiImplicitParam(name = "sessionid", value = "服务端给的的id", paramType = "query")
    })
    public Result register(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception {
        String tamp = (String) request.getParameter("tamp");
        String code = (String) request.getParameter("code");
        String sessionid = (String) request.getParameter("sessionid");
        if ((code == null || code.equals("")) ||
                (sessionid == null || sessionid.equals("")) ||
                (tamp == null || tamp.equals(""))) {
            return Result.fail("参数不齐全", ErrorCode.BAD_REQUEST);
        }
        System.out.println(userDto.toString());
        if (userDto.getPhone() != null) {
            // 校验验证码
            if (MessageServiceImpl.messageEncode(userDto.getPhone() + code).equals(sessionid)) {
                // 校验时间
                if (tamp.compareTo(new SimpleDateFormat(Utils.DATE_FORMAT_SIMPLE).format(new Date())) < 0) {

                    return Result.fail("验证码已过期", ErrorCode.BAD_REQUEST);
                } else {
                    return userService.register(userDto, Utils.getIpAddr(request));
                }
            } else {
                return Result.fail("验证码不正确", ErrorCode.BAD_REQUEST);
            }
        } else {
            return  Result.fail("手机号不存在", ErrorCode.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "用户通过Token获取个人信息")
    @GetMapping("/getUserInfoByToken")
    @ApiImplicitParam(name = "Authorization", value = "用户的token", paramType = "query", dataType = "header")
    public Result getUserInfoByToken(@RequestHeader("Authorization") String token) throws Exception {
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        return userService.getUserByID(uid);
    }

    @ApiOperation(value = "用户通过token更改个人信息")
    @PostMapping("/updateUserInfoByToken")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "用户的token", paramType = "query", dataType = "header"),
            @ApiImplicitParam(name = "userDto", value = "用户的实体，个人信息")
    })
    public Result updateUserInfoByToken(@RequestBody UserDto userDto,
                                        @RequestHeader("Authorization") String token) throws Exception{
        String uid = (String) JwtUtils.parseJWT(token).get("sub");
        userDto.setUid(uid);
        return userService.updateUserInfoByUser(userDto);
    }
}