package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.OutfitUserWokerOrderEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitUserWorkerOrderRepository extends JpaRepository<OutfitUserWokerOrderEntity, String>, BaseRepository<OutfitUserWokerOrderEntity, String> {
}