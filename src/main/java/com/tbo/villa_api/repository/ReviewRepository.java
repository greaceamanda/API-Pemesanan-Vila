package com.tbo.villa_api.repository;

import com.tbo.villa_api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBookingCustomerId(Long customerId);
    List<Review> findByBookingRoomTypeVillaId(Long villaId);
}
