package com.dh.meli.perolas.service;

import com.dh.meli.perolas.model.JewelDB;
import com.dh.meli.perolas.repository.InterfaceJewelDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dh.meli.perolas.exceptions.*;

import java.util.List;
import java.util.Map;

@Service
public class JewelDBService implements InterfaceJewelDBService {

    @Autowired
    private InterfaceJewelDBRepository jewelRepo;

    @Override
    public JewelDB getJewelById(Long id) {
        return jewelRepo.findById(id).orElseThrow(()-> new JewelNotFoundException("Jewel not found."));
    }

    @Override
    public List<JewelDB> getAllJewels() {
        return (List<JewelDB>) jewelRepo.findAll();
    }

    @Override
    public JewelDB createNewJewel(JewelDB newJewel) {
        if (newJewel.getId() != null) {
            throw new JewelBadRequestException("The Jewel cannot have a ID to be insert on database");
        }
        return jewelRepo.save(newJewel);
    }

    @Override
    public JewelDB updateJewel(JewelDB newJewelInfo) {
        getJewelById(newJewelInfo.getId());
        return jewelRepo.save(newJewelInfo);
    }

    @Override
    public JewelDB updatePartialJewel(Long id, Map<String, ?> changes) {
        JewelDB jewelFound = getJewelById(id);

        changes.forEach((key, value) -> {
            switch (key) {
                case "material": jewelFound.setMaterial((String) value); break;
                case "weight": jewelFound.setWeight((Double) value); break;
                case "carats": jewelFound.setCarats((Integer) value); break;
            }
        });

        return jewelRepo.save(jewelFound);
    }

    @Override
    public void deleteJewel(Long id) {
        JewelDB jewelFound = getJewelById(id);
        jewelRepo.delete(jewelFound);
    }
}
