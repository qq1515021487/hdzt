package com.bnuz.service.impl.admin;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.entity.AdminUserEntity;
import com.bnuz.repository.AdminUserRepository;
import com.bnuz.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUserEntity, Long> implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public BaseRepository<AdminUserEntity, Long> getRepository() {
        return adminUserRepository;
    }


}