package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityRaterPointTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRaterPointTableRepository extends JpaRepository<ActivityRaterPointTableEntity, String>, BaseRepository<ActivityRaterPointTableEntity, String> {

}