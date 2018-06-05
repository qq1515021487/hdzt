package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityRaterAssessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRaterAssessRepository extends JpaRepository<ActivityRaterAssessEntity, String>, BaseRepository<ActivityRaterAssessEntity, String> {

}