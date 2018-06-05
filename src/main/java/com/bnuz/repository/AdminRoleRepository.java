package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.AdminRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminRoleRepository extends JpaRepository<AdminRoleEntity, Long>, BaseRepository<AdminRoleEntity, Long> {

}