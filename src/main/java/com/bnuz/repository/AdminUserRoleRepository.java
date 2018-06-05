package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.AdminUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminUserRoleRepository extends JpaRepository<AdminUserRoleEntity, Long>, BaseRepository<AdminUserRoleEntity, Long> {

}