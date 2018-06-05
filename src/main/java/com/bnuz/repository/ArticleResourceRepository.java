package com.bnuz.repository;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ArticleResourceEntity;
import com.bnuz.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleResourceRepository extends JpaRepository<ArticleResourceEntity, Integer>, BaseRepository<ArticleResourceEntity, Integer> {
}