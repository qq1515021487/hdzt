package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.OutfitArticleEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitArticleRepository extends JpaRepository<OutfitArticleEntity, String>, BaseRepository<OutfitArticleEntity, String> {
}