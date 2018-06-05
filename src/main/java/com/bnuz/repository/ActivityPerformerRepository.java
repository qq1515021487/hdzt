package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityPerformerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityPerformerRepository extends JpaRepository<ActivityPerformerEntity, String>, BaseRepository<ActivityPerformerEntity, String> {

}