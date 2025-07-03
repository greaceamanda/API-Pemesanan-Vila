package com.tbo.villa_api.service;

import com.tbo.villa_api.model.Villa;
import com.tbo.villa_api.repository.VillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tbo.villa_api.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class VillaService {

    @Autowired
    private VillaRepository villaRepository;

    // ✅ Ambil semua vila
    public List<Villa> getAllVillas() {
        return villaRepository.findAll();
    }

    // ✅ Ambil vila by ID
    public Villa getVillaById(Long id) {
        return villaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Villa not found with id: " + id));
    }

    // ✅ Tambah vila baru
    public Villa createVilla(Villa villa) {
        return villaRepository.save(villa);
    }

    // ✅ Ubah data vila
    public Villa updateVilla(Long id, Villa updatedVilla) {
        Villa villa = getVillaById(id);
        villa.setName(updatedVilla.getName());
        villa.setDescription(updatedVilla.getDescription());
        villa.setAddress(updatedVilla.getAddress());
        return villaRepository.save(villa);
    }

    // ✅ Hapus vila
    public void deleteVilla(Long id) {
        villaRepository.deleteById(id);
    }

    // ✅ Cari vila berdasarkan tanggal check-in dan check-out
    public List<Villa> getAvailableVillas(LocalDate checkIn, LocalDate checkOut) {
        return villaRepository.findAll();
    }
}
