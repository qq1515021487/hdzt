package com.bnuz.controller;

import com.bnuz.commons.baseController.BaseController;
import com.bnuz.commons.baseService.BaseService;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.entity.*;
import com.bnuz.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController extends BaseController<TestEntity, Integer> {

    @Autowired
    private TestService testService;

    @Override
    public BaseService<TestEntity, Integer> getService() {
        return testService;
    }

    @ApiOperation("获取所有测试对象")
    @GetMapping("/getTestAll")
    public Result getTestAll() {
        return Result.success(testService.findAll());
    }



    @ApiOperation("获取所有对象")
    @GetMapping("/getAllObject")
    public Result getAllObject() {
        Map<Object, Object> map = new HashedMap();
        map.put("userEntity", new UserEntity());
        map.put("adminUserEntity", new AdminUserEntity());
        map.put("activityAttendentEntity", new ActivityAttendentEntity());
        map.put("activityAttendentInfoEntity", new ActivityAttendentInfoEntity());
        map.put("activityEntity", new ActivityEntity());

        return Result.success(map);
    }
}