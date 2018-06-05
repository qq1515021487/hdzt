package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.OutfitFunctionEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitFuncationRepository extends JpaRepository<OutfitFunctionEntity, Integer>, BaseRepository<OutfitFunctionEntity, Integer> {
}