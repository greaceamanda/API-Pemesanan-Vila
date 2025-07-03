package com.tbo.villa_api.service;

import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.model.Customer;
import com.tbo.villa_api.model.RoomType;
import com.tbo.villa_api.repository.BookingRepository;
import com.tbo.villa_api.repository.CustomerRepository;
import com.tbo.villa_api.repository.RoomTypeRepository;
import com.tbo.villa_api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public Booking createBookingForCustomer(Long customerId, Booking booking) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        RoomType roomType = roomTypeRepository.findById(booking.getRoomType().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Room type not found"));

        booking.setCustomer(customer);
        booking.setRoomType(roomType);
        // Tambahkan logika validasi atau perhitungan final_price di sini jika perlu
        return bookingRepository.save(booking);
    }
}
