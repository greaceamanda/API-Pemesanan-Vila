package com.tbo.villa_api.dto;

import java.time.LocalDateTime;

public class BookingSummaryDTO {
    private Long id;
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
    private Integer finalPrice;
    private String paymentStatus;

    public BookingSummaryDTO() {}

    public BookingSummaryDTO(Long id, LocalDateTime checkinDate, LocalDateTime checkoutDate,
                             Integer finalPrice, String paymentStatus) {
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.finalPrice = finalPrice;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getCheckinDate() { return checkinDate; }
    public void setCheckinDate(LocalDateTime checkinDate) { this.checkinDate = checkinDate; }

    public LocalDateTime getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(LocalDateTime checkoutDate) { this.checkoutDate = checkoutDate; }

    public Integer getFinalPrice() { return finalPrice; }
    public void setFinalPrice(Integer finalPrice) { this.finalPrice = finalPrice; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
