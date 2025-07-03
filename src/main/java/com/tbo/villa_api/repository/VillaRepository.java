package com.tbo.villa_api.repository;

import com.tbo.villa_api.model.Villa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillaRepository extends JpaRepository<Villa, Long> {
}
