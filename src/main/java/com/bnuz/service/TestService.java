package com.bnuz.service;

import com.bnuz.commons.baseService.BaseService;
import com.bnuz.entity.TestEntity;
import com.bnuz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by QuanQqqqq on 2018/4/2.
 */
public interface TestService extends BaseService<TestEntity, Integer> {

}