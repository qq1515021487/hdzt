package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.AdminUserRolePermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminUserRolePermissionsRepository extends JpaRepository<AdminUserRolePermissionsEntity, Long>, BaseRepository<AdminUserRolePermissionsEntity, Long> {

}