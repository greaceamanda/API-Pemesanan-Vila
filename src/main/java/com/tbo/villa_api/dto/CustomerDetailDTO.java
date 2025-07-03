package com.tbo.villa_api.dto;

import java.util.List;

public class CustomerDetailDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<BookingSummaryDTO> bookings;

    public CustomerDetailDTO() {}

    public CustomerDetailDTO(Long id, String name, String email, String phone,
                             List<BookingSummaryDTO> bookings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookings = bookings;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<BookingSummaryDTO> getBookings() { return bookings; }
    public void setBookings(List<BookingSummaryDTO> bookings) { this.bookings = bookings; }
}
