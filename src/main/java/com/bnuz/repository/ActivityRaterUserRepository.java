package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityRaterUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRaterUserRepository extends JpaRepository<ActivityRaterUserEntity, String>, BaseRepository<ActivityRaterUserEntity, String> {

}