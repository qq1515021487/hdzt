package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityHistoryRepository extends JpaRepository<ActivityHistoryEntity, String>, BaseRepository<ActivityHistoryEntity, String> {

}