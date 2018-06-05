package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityAttendentEntity;
import com.bnuz.entity.ActivityAttendentInfoEntity;
import com.bnuz.entity.dto.ActivityAttendentDto;
import com.bnuz.entity.dto.ActivityAttendentInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityAttendentInfoRepository extends JpaRepository<ActivityAttendentInfoDto, String>, BaseRepository<ActivityAttendentInfoDto, String> {

    ActivityAttendentInfoDto findByWechatOpenid(String wechatOpenid);


    ActivityAttendentInfoDto findByAttendentId(String attendentId);

}