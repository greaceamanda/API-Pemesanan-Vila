package com.tbo.villa_api.service;

import com.tbo.villa_api.model.Villa;
import com.tbo.villa_api.repository.VillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillaService {

    @Autowired
    private VillaRepository villaRepository;

    public List<Villa> getAllVillas() {
        return villaRepository.findAll();
    }

    public Villa getVillaById(Long id) {
        return villaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Villa not found with id: " + id));
    }

    public Villa createVilla(Villa villa) {
        return villaRepository.save(villa);
    }

    public Villa updateVilla(Long id, Villa updatedVilla) {
        Villa villa = getVillaById(id);
        villa.setName(updatedVilla.getName());
        villa.setDescription(updatedVilla.getDescription());
        villa.setAddress(updatedVilla.getAddress());
        return villaRepository.save(villa);
    }

    public void deleteVilla(Long id) {
        villaRepository.deleteById(id);
    }
}
