package com.bnuz.service.impl;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.entity.TestEntity;
import com.bnuz.repository.TestRepository;
import com.bnuz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestServiceImpl extends BaseServiceImpl<TestEntity, Integer> implements TestService {
    @Autowired
    private TestRepository testRepository;

    @Override
    public BaseRepository<TestEntity, Integer> getRepository() {
        return testRepository;
    }

}