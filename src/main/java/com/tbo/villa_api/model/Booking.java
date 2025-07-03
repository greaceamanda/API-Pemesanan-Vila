package com.tbo.villa_api.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relasi ke customer
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    // Relasi ke room_type
    @ManyToOne
    @JoinColumn(name = "room_type")
    private RoomType roomType;

    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;

    private Integer price;

    // Relasi ke voucher (opsional)
    @ManyToOne
    @JoinColumn(name = "voucher")
    private Voucher voucher;

    private Integer finalPrice;

    private String paymentStatus; // waiting, failed, success
    private boolean hasCheckedin;
    private boolean hasCheckedout;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public RoomType getRoomType() { return roomType; }
    public void setRoomType(RoomType roomType) { this.roomType = roomType; }

    public LocalDateTime getCheckinDate() { return checkinDate; }
    public void setCheckinDate(LocalDateTime checkinDate) { this.checkinDate = checkinDate; }

    public LocalDateTime getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(LocalDateTime checkoutDate) { this.checkoutDate = checkoutDate; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public Voucher getVoucher() { return voucher; }
    public void setVoucher(Voucher voucher) { this.voucher = voucher; }

    public Integer getFinalPrice() { return finalPrice; }
    public void setFinalPrice(Integer finalPrice) { this.finalPrice = finalPrice; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public boolean isHasCheckedin() { return hasCheckedin; }
    public void setHasCheckedin(boolean hasCheckedin) { this.hasCheckedin = hasCheckedin; }

    public boolean isHasCheckedout() { return hasCheckedout; }
    public void setHasCheckedout(boolean hasCheckedout) { this.hasCheckedout = hasCheckedout; }
}
