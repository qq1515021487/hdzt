package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityEntity;
import com.bnuz.entity.ActivityEntity;
import com.bnuz.entity.dto.ActivityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityDto, String>, BaseRepository<ActivityDto, String> {

    /**
     * 通过Uid查找用户创建的活动，并按照时间排序
     * @param uid
     * @param pageable
     * @return
     */
    Slice<ActivityDto> findByUidOrderByCreateTimeDesc(String uid, Pageable pageable);

    /**
     * 根据6位有效码和有效时间找到活动详情
     * @param activityCode
     * @param createTime
     * @return
     */
    ActivityDto findByActivityCodeAndCreateTimeGreaterThan(String activityCode, Long createTime);

    ActivityDto findByAcid(String acid);


    @Query("select count(activity.acid) from ActivityDto as activity where activity.uid=:uid")
    int getActivityCountByUid(@Param("uid") String uid);
}