package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.dto.ActivityAttendentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityAttendentRepository extends JpaRepository<ActivityAttendentDto, String>, BaseRepository<ActivityAttendentDto, String> {

    ActivityAttendentDto findByWechatOpenid(String wechatOpenId);

    List<ActivityAttendentDto> findByAttendentId(String attendentId);

    ActivityAttendentDto findByAttendentIdAndAcid(String attendentId, String acid);

    List<ActivityAttendentDto> findActivityAttendentDtosByAcid(String acid);
}