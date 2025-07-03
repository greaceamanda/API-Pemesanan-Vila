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
import java.util.Map;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/villas")
public class VillaController {

    @Autowired
    private VillaService villaService;

    @Autowired
    private RoomTypeService roomTypeService;

    // ✅ GET /villas - Semua vila
    @GetMapping
    public ResponseEntity<List<Villa>> getAllVillas() {
        return ResponseEntity.ok(villaService.getAllVillas());
    }

    // ✅ GET /villas?ci_date=...&co_date=... - Cek ketersediaan berdasarkan tanggal
    @GetMapping(params = {"ci_date", "co_date"})
    public ResponseEntity<?> getAvailableVillas(
            @RequestParam("ci_date") String checkInDateStr,
            @RequestParam("co_date") String checkOutDateStr) {

        try {
            // Parsing dan validasi format tanggal
            LocalDate checkInDate = LocalDate.parse(checkInDateStr);
            LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);

            // Lanjutkan ke service layer
            List<Villa> available = villaService.getAvailableVillas(checkInDate, checkOutDate);
            return ResponseEntity.ok(available);

        } catch (DateTimeParseException e) {
            // Jika format salah, kembalikan pesan error
            return ResponseEntity.badRequest().body(
                Map.of("error", "Format tanggal tidak valid. Gunakan format yyyy-MM-dd.")
            );
        }
    }

    // ✅ GET /villas/{id} - Detail vila
    @GetMapping("/{id}")
    public Villa getVillaById(@PathVariable Long id) {
        return villaService.getVillaById(id);
    }

    // ✅ POST /villas - Tambah vila
    @PostMapping
    public Villa createVilla(@Valid @RequestBody Villa villa) {
        return villaService.createVilla(villa);
    }

    // ✅ PUT /villas/{id} - Ubah vila
    @PutMapping("/{id}")
    public Villa updateVilla(@PathVariable Long id, @Valid @RequestBody Villa villa) {
        return villaService.updateVilla(id, villa);
    }

    // ✅ DELETE /villas/{id} - Hapus vila
    @DeleteMapping("/{id}")
    public void deleteVilla(@PathVariable Long id) {
        villaService.deleteVilla(id);
    }

    // ✅ GET /villas/{id}/rooms - Daftar kamar
    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<RoomType>> getRoomsForVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getRoomsByVillaId(id));
    }

    // ✅ POST /villas/{id}/rooms - Tambah kamar
    @PostMapping("/{id}/rooms")
    public RoomType addRoomToVilla(@PathVariable Long id, @Valid @RequestBody RoomType roomType) {
        return roomTypeService.addRoomToVilla(id, roomType);
    }

    // ✅ PUT /villas/{id}/rooms/{id} - Ubah kamar
    @PutMapping("/{villaId}/rooms/{roomId}")
    public RoomType updateRoom(
            @PathVariable Long villaId,
            @PathVariable Long roomId,
            @Valid @RequestBody RoomType roomType) {
        return roomTypeService.updateRoom(roomId, roomType);
    }

    // ✅ DELETE /villas/{id}/rooms/{id} - Hapus kamar
    @DeleteMapping("/{villaId}/rooms/{roomId}")
    public void deleteRoom(@PathVariable Long villaId, @PathVariable Long roomId) {
        roomTypeService.deleteRoom(roomId);
    }

    // ✅ GET /villas/{id}/bookings - Booking vila
    @GetMapping("/{id}/bookings")
    public ResponseEntity<List<Booking>> getBookingsByVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getBookingsByVillaId(id));
    }

    // ✅ GET /villas/{id}/reviews - Review vila
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByVilla(@PathVariable Long id) {
        return ResponseEntity.ok(roomTypeService.getReviewsByVillaId(id));
    }
}
