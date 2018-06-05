package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityVoteOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityVoteOptionRepository extends JpaRepository<ActivityVoteOptionEntity, String>, BaseRepository<ActivityVoteOptionEntity, String> {

}