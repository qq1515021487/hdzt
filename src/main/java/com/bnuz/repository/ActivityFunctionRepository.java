package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityFunctionRepository extends JpaRepository<ActivityFunctionEntity, Integer>, BaseRepository<ActivityFunctionEntity, Integer> {

}