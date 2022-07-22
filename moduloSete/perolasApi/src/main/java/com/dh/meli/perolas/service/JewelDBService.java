package com.dh.meli.perolas.service;

import com.dh.meli.perolas.model.JewelDB;
import com.dh.meli.perolas.repository.InterfaceJewelDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dh.meli.perolas.exceptions.*;

import java.util.List;

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
        if (newJewel.getId() != 0) return null;
        return jewelRepo.save(newJewel);
    }

    @Override
    public JewelDB updateJewel(Long id) {
        return null;
    }

    @Override
    public void deleteJewel(Long id) {
        if (jewelRepo.findById(id).isPresent()) {
            jewelRepo.deleteById(id);
        }
    }

}
