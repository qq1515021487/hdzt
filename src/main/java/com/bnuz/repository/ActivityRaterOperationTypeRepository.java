package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityRaterOperationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRaterOperationTypeRepository extends JpaRepository<ActivityRaterOperationTypeEntity, String>, BaseRepository<ActivityRaterOperationTypeEntity, String> {

}