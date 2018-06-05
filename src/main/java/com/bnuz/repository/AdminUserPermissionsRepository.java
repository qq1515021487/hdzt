package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.AdminUserPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminUserPermissionsRepository extends JpaRepository<AdminUserPermissionsEntity, Long>, BaseRepository<AdminUserPermissionsEntity, Long> {

}