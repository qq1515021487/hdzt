package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityVoteUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityVoteUserRepository extends JpaRepository<ActivityVoteUserEntity, String>, BaseRepository<ActivityVoteUserEntity, String> {

}