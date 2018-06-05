package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityNoteRepository extends JpaRepository<ActivityNoteEntity, String>, BaseRepository<ActivityNoteEntity, String> {

}