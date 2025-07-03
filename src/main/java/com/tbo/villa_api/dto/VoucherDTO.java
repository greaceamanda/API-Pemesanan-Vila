package com.tbo.villa_api.dto;

import java.time.LocalDateTime;

public class VoucherDTO {
    private Long id;
    private String code;
    private String description;
    private Double discount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public VoucherDTO() {}

    public VoucherDTO(Long id, String code, String description, Double discount, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
}
