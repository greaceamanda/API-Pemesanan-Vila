package com.tbo.villa_api.repository;

import com.tbo.villa_api.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    List<RoomType> findByVillaId(Long villaId);
}
