package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.TestEntity;
import com.bnuz.entity.UserBillEntity;
import com.bnuz.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBillRepository extends JpaRepository<UserBillEntity, String>, BaseRepository<UserBillEntity, String> {
}