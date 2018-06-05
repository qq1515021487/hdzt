package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.OutfitInfoEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitInfoRepository extends JpaRepository<OutfitInfoEntity, String>, BaseRepository<OutfitInfoEntity, String> {
}