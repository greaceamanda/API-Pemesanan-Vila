package com.tbo.villa_api.service;

import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.model.Booking;
// import com.tbo.villa_api.model.Customer;
import com.tbo.villa_api.repository.ReviewRepository;
import com.tbo.villa_api.repository.BookingRepository;
// import com.tbo.villa_api.repository.CustomerRepository;
import com.tbo.villa_api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // @Autowired
    // private CustomerRepository customerRepository;

    public List<Review> getReviewsByCustomerId(Long customerId) {
        // Ambil semua booking oleh customer, lalu ambil review dari booking itu
        return reviewRepository.findByBookingCustomerId(customerId);
    }

    public List<Review> getReviewsByVillaId(Long villaId) {
        return reviewRepository.findByBookingRoomTypeVillaId(villaId);
    }

    public Review createReviewForBooking(Long customerId, Long bookingId, Review review) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getCustomer().getId().equals(customerId)) {
            throw new ResourceNotFoundException("Customer does not match this booking");
        }

        review.setBooking(booking);
        return reviewRepository.save(review);
    }
}
