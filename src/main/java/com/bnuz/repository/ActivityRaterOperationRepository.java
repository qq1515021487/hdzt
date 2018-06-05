package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityRaterOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRaterOperationRepository extends JpaRepository<ActivityRaterOperationEntity, String>, BaseRepository<ActivityRaterOperationEntity, String> {

}