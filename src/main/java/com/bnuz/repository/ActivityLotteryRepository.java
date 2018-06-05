package com.bnuz.repository;
import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.entity.ActivityLotteryEntity;
import com.bnuz.entity.dto.ActivityLotteryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityLotteryRepository extends JpaRepository<ActivityLotteryDto, String>, BaseRepository<ActivityLotteryDto, String> {

    Slice<ActivityLotteryDto> findByAcidOrderByCreateTimeDesc(String acid, Pageable pageable);

}