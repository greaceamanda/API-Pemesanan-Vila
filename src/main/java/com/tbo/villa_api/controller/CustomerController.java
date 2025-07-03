package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Customer;
import com.tbo.villa_api.model.Booking;
import com.tbo.villa_api.model.Review;
import com.tbo.villa_api.service.CustomerService;
import com.tbo.villa_api.service.BookingService;
import com.tbo.villa_api.service.ReviewService;
import com.tbo.villa_api.exception.ResourceNotFoundException;

import com.tbo.villa_api.dto.CustomerDetailDTO;
import com.tbo.villa_api.dto.BookingSummaryDTO;

import com.tbo.villa_api.dto.CustomerDTO;
import java.util.stream.Collectors;

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

    // ✅ GET /customers
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        List<CustomerDTO> dtos = customers.stream().map(c ->
            new CustomerDTO(c.getId(), c.getName(), c.getEmail(), c.getPhone())
        ).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // ✅ GET /customers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailDTO> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + id + " tidak ditemukan.");
        }

        List<BookingSummaryDTO> bookingSummaries = customer.getBookings().stream().map(b -> 
            new BookingSummaryDTO(
                b.getId(),
                b.getCheckinDate(),
                b.getCheckoutDate(),
                b.getFinalPrice(),
                b.getPaymentStatus()
            )
        ).collect(Collectors.toList());

        CustomerDetailDTO dto = new CustomerDetailDTO(
            customer.getId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPhone(),
            bookingSummaries
        );

        return ResponseEntity.ok(dto);
    }

    // ✅ POST /customers
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer created = customerService.createCustomer(customer);
        return ResponseEntity.status(201).body(created);
    }

    // ✅ PUT /customers/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        if (customerService.getCustomerById(id) == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + id + " tidak ditemukan.");
        }
        Customer updated = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updated);
    }

    // ✅ GET /customers/{id}/bookings
    @GetMapping("/{id}/bookings")
    public ResponseEntity<List<BookingSummaryDTO>> getBookingsByCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + id + " tidak ditemukan.");
        }

        List<BookingSummaryDTO> bookings = customer.getBookings().stream().filter(b -> b != null && b.getCheckinDate() != null && b.getCheckoutDate() != null)
            .map(b -> new BookingSummaryDTO(
                b.getId(),
                b.getCheckinDate(),
                b.getCheckoutDate(),
                b.getFinalPrice(),
                b.getPaymentStatus()
            )
        ).collect(Collectors.toList());

        return ResponseEntity.ok(bookings);
    }

    // ✅ GET /customers/{id}/reviews
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByCustomer(@PathVariable Long id) {
        if (customerService.getCustomerById(id) == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + id + " tidak ditemukan.");
        }
        return ResponseEntity.ok(reviewService.getReviewsByCustomerId(id));
    }

    // ✅ POST /customers/{id}/bookings
    @PostMapping("/{id}/bookings")
    public ResponseEntity<Booking> createBooking(@PathVariable Long id, @Valid @RequestBody Booking booking) {
        if (customerService.getCustomerById(id) == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + id + " tidak ditemukan.");
        }
        Booking created = bookingService.createBookingForCustomer(id, booking);
        return ResponseEntity.status(201).body(created);
    }

    // ✅ POST /customers/{id}/bookings/{id}/reviews
    @PostMapping("/{customerId}/bookings/{bookingId}/reviews")
    public ResponseEntity<Review> createReview(
            @PathVariable Long customerId,
            @PathVariable Long bookingId,
            @Valid @RequestBody Review review) {

        if (customerService.getCustomerById(customerId) == null) {
            throw new ResourceNotFoundException("Customer dengan ID " + customerId + " tidak ditemukan.");
        }

        Review created = reviewService.createReviewForBooking(customerId, bookingId, review);
        return ResponseEntity.status(201).body(created);
    }
}
