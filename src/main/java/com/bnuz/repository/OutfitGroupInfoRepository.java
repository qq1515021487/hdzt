package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.OutfitGroupInfoEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitGroupInfoRepository extends JpaRepository<OutfitGroupInfoEntity, String>, BaseRepository<OutfitGroupInfoEntity, String> {
}