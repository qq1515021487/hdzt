package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.TestEntity;
import com.bnuz.entity.UserEntity;
import com.bnuz.entity.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, String>, BaseRepository<UserDto, String> {

    /**
     * 根据用户名查用户
     * @param username
     * @return
     */
    UserDto findByUsername(String username);

    /**
     * 根据手机查找用户
     * @param phone
     * @return
     */
    UserDto findByPhone(String phone);

    UserDto findByUid(String uid);
}