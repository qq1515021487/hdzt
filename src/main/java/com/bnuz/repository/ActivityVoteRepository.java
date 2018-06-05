package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityVoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityVoteRepository extends JpaRepository<ActivityVoteEntity, String>, BaseRepository<ActivityVoteEntity, String> {

}