package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by QuanQqqqq on 2018/4/2.
 */
public interface TestRepository extends JpaRepository<TestEntity, Integer>, BaseRepository<TestEntity, Integer> {

}