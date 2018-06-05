package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminUserRepository extends JpaRepository<AdminUserEntity, Long>, BaseRepository<AdminUserEntity, Long> {

    /**
     * 根据用户名查用户
     * @param username
     * @return
     */
    AdminUserEntity findByUsername(String username);
}