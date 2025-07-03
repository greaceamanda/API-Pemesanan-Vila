package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Villa;
import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.model.RoomType;
import com.tbo.villa_api.service.VillaService;
import com.tbo.villa_api.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/villas")
public class VillaController {

    @Autowired
    private VillaService villaService;

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    public ResponseEntity<List<Villa>> getAllVillas() {
        return ResponseEntity.ok(villaService.getAllVillas());
    }

    @GetMapping("/{id}")
    public Villa getVillaById(@PathVariable Long id) {
        return villaService.getVillaById(id);
    }

    @PostMapping
    public Villa createVilla(@Valid @RequestBody Villa villa) {
        return villaService.createVilla(villa);
    }

    @PutMapping("/{id}")
    public Villa updateVilla(@PathVariable Long id, @Valid @RequestBody Villa villa) {
        return villaService.updateVilla(id, villa);
    }

    @DeleteMapping("/{id}")
    public void deleteVilla(@PathVariable Long id) {
        villaService.deleteVilla(id);
    }

    // --- Endpoint tambahan khusus villa ---

    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<RoomType>> getRoomsForVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getRoomsByVillaId(id));
    }

    @PostMapping("/{id}/rooms")
    public RoomType addRoomToVilla(@PathVariable Long id, @Valid @RequestBody RoomType roomType) {
        return roomTypeService.addRoomToVilla(id, roomType);
    }

    @PutMapping("/{villaId}/rooms/{roomId}")
    public RoomType updateRoom(@PathVariable Long roomId, @RequestBody RoomType roomType) {
        return roomTypeService.updateRoom(roomId, roomType);
    }

    @DeleteMapping("/{villaId}/rooms/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomTypeService.deleteRoom(roomId);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<List<Booking>> getBookingsByVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getBookingsByVillaId(id));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getReviewsByVillaId(id));
    }

}
