package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityLotteryPeopleEntity;
import com.bnuz.entity.dto.ActivityLotteryPeopleDto;
import org.hibernate.annotations.NamedNativeQueries;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityLotteryPeoleRepository extends JpaRepository<ActivityLotteryPeopleDto, String>, BaseRepository<ActivityLotteryPeopleDto, String> {
//    public List<ActivityLotteryPeopleEntity> findByPridLeftJoin
    List<ActivityLotteryPeopleDto> findActivityLotteryPeopleDtosByAcidOrderByGainTimeDesc(String acid, Pageable pageable);

    List<ActivityLotteryPeopleDto> findActivityLotteryPeopleDtosByAlidOrderByGainTimeDesc(String alid, Pageable pageable);

    @Query(value = "SELECT c.* FROM t_activity_attendent_info as a left join t_activity_attendent as b on a.attendent_id = b.attendent_id " +
            "left join t_activity_lottery_people as c on b.prid = c.prid WHERE a.attendent_id = :attendentId ORDER BY c.gain_time DESC limit :page, :pageSize", nativeQuery = true)
    List<ActivityLotteryPeopleDto> findActivityLotteryPeopleDtosByAttendentIdOrderByGainTimeDesc(@Param("attendentId") String attendentId,
                                                                                                 @Param("page") int page,
                                                                                                 @Param("pageSize") int pageSize);

    List<ActivityLotteryPeopleDto> findActivityLotteryPeopleDtosByPridOrderByGainTimeDesc(String prid, Pageable pageable);
}