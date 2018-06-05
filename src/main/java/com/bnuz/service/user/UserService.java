package com.bnuz.service.user;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.UserEntity;
import com.bnuz.entity.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends BaseService<UserDto, String> {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);

    /**
     * 用户注册
     * @param userEntity
     * @return
     */
    Result register(UserDto userDto, String ip);

    Result updateUserInfoByUser(UserDto userDto);

    Result getUserByID(String uid);
}