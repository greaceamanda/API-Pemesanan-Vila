package com.tbo.villa_api.controller;

import com.tbo.villa_api.model.Voucher;
import com.tbo.villa_api.service.VoucherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping
    public ResponseEntity<List<Voucher>> getAllVouchers() {
        return ResponseEntity.ok(voucherService.getAllVouchers());
    }

    @GetMapping("/{id}")
    public Voucher getVoucherById(@PathVariable Long id) {
        return voucherService.getVoucherById(id);
    }

    @PostMapping
    public Voucher createVoucher(@Valid @RequestBody Voucher voucher) {
        return voucherService.createVoucher(voucher);
    }

    @PutMapping("/{id}")
    public Voucher updateVoucher(@PathVariable Long id, @Valid @RequestBody Voucher voucher) {
        return voucherService.updateVoucher(id, voucher);
    }

    @DeleteMapping("/{id}")
    public void deleteVoucher(@PathVariable Long id) {
        voucherService.deleteVoucher(id);
    }
}
