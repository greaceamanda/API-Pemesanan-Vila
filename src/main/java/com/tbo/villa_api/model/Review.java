package com.tbo.villa_api.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "booking")
    private Long bookingId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "booking")
    private Booking booking;

    private int star;

    private String title;

    private String content;

    // Getter & Setter
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public int getStar() { return star; }
    public void setStar(int star) { this.star = star; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
