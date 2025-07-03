package com.tbo.villa_api.service;

import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.model.RoomType;
import com.tbo.villa_api.model.Villa;
import com.tbo.villa_api.repository.BookingRepository;
import com.tbo.villa_api.repository.ReviewRepository;
import com.tbo.villa_api.repository.RoomTypeRepository;
import com.tbo.villa_api.repository.VillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private VillaRepository villaRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<RoomType> getRoomsByVillaId(Long villaId) {
        return roomTypeRepository.findByVillaId(villaId);
    }

    public RoomType addRoomToVilla(Long villaId, RoomType roomType) {
        Villa villa = villaRepository.findById(villaId)
                .orElseThrow(() -> new RuntimeException("Villa not found"));
        roomType.setVilla(villa);
        return roomTypeRepository.save(roomType);
    }

    public RoomType updateRoom(Long id, RoomType updatedRoom) {
        RoomType room = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setName(updatedRoom.getName());
        room.setQuantity(updatedRoom.getQuantity());
        room.setCapacity(updatedRoom.getCapacity());
        room.setPrice(updatedRoom.getPrice());
        room.setBedSize(updatedRoom.getBedSize());
        room.setHasDesk(updatedRoom.isHasDesk());
        room.setHasAc(updatedRoom.isHasAc());
        room.setHasTv(updatedRoom.isHasTv());
        room.setHasWifi(updatedRoom.isHasWifi());
        room.setHasShower(updatedRoom.isHasShower());
        room.setHasHotwater(updatedRoom.isHasHotwater());
        room.setHasFridge(updatedRoom.isHasFridge());
        return roomTypeRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomTypeRepository.deleteById(id);
    }

    public List<Booking> getBookingsByVillaId(Long villaId) {
        return bookingRepository.findByRoomTypeVillaId(villaId);
    }

    public List<Review> getReviewsByVillaId(Long villaId) {
        return reviewRepository.findByBookingRoomTypeVillaId(villaId);
    }
}
