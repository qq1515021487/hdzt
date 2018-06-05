package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ReportEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, String>, BaseRepository<ReportEntity, String> {
}