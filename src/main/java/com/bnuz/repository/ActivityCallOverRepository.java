package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.dto.ActivityCallOverDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityCallOverRepository extends JpaRepository<ActivityCallOverDto, String>, BaseRepository<ActivityCallOverDto, String> {

    List<ActivityCallOverDto> findByAcid(String acid);

    ActivityCallOverDto findByAcidAndCallOverCodeAndName(String acid, String callOverCode, String name);
}