package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.service.BookingService;
import com.tbo.villa_api.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ✅ GET /bookings - ambil semua booking
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // ✅ GET /bookings/{id} - ambil satu booking
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        // bookingService akan langsung lempar ResourceNotFoundException jika null
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }
}
