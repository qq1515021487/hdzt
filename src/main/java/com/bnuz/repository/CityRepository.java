package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.CityEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Integer>, BaseRepository<CityEntity, Integer> {
}