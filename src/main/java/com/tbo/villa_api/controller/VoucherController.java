package com.tbo.villa_api.controller;

import com.tbo.villa_api.dto.VoucherDTO;
import com.tbo.villa_api.model.Voucher;
import com.tbo.villa_api.service.VoucherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    // ✅ GET /vouchers
    @GetMapping
    public ResponseEntity<List<VoucherDTO>> getAllVouchers() {
        List<Voucher> vouchers = voucherService.getAllVouchers();
        List<VoucherDTO> dtoList = vouchers.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    // ✅ GET /vouchers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<VoucherDTO> getVoucherById(@PathVariable Long id) {
        Voucher voucher = voucherService.getVoucherById(id);
        return ResponseEntity.ok(convertToDTO(voucher));
    }

    // ✅ POST /vouchers
    @PostMapping
    public ResponseEntity<VoucherDTO> createVoucher(@Valid @RequestBody Voucher voucher) {
        Voucher created = voucherService.createVoucher(voucher);
        return ResponseEntity.status(201).body(convertToDTO(created));
    }

    // ✅ PUT /vouchers/{id}
    @PutMapping("/{id}")
    public ResponseEntity<VoucherDTO> updateVoucher(@PathVariable Long id, @Valid @RequestBody Voucher voucher) {
        Voucher updated = voucherService.updateVoucher(id, voucher);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    // ✅ DELETE /vouchers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        voucherService.deleteVoucher(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method untuk konversi
    private VoucherDTO convertToDTO(Voucher v) {
        return new VoucherDTO(
            v.getId(),
            v.getCode(),
            v.getDescription(),
            v.getDiscount(),
            v.getStartDate(),
            v.getEndDate()
        );
    }
}
