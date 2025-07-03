package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Customer;
import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.service.CustomerService;
import com.tbo.villa_api.service.BookingService;
import com.tbo.villa_api.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<List<Booking>> getBookingsByCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingsByCustomerId(id));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewsByCustomerId(id));
    }

    @PostMapping("/{id}/bookings")
    public Booking createBooking(@PathVariable Long id, @Valid @RequestBody Booking booking) {
        return bookingService.createBookingForCustomer(id, booking);
    }

    @PostMapping("/{customerId}/bookings/{bookingId}/reviews")
    public Review createReview(@PathVariable Long customerId,
                               @PathVariable Long bookingId,
                               @Valid @RequestBody Review review) {
        return reviewService.createReviewForBooking(customerId, bookingId, review);
    }
}
