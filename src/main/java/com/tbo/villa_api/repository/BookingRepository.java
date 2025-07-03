package com.tbo.villa_api.repository;

import com.tbo.villa_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomTypeVillaId(Long villaId);
    List<Booking> findByCustomerId(Long customerId);

}

