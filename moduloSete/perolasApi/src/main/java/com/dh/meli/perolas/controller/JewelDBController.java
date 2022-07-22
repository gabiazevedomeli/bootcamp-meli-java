package com.dh.meli.perolas.controller;


import com.dh.meli.perolas.model.JewelDB;
import com.dh.meli.perolas.service.JewelDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/jewels")
public class JewelDBController {

    @Autowired
    private JewelDBService jewelService;

    @GetMapping("/{id}")
    public ResponseEntity<JewelDB> getJewelById(@PathVariable Long id) {
        JewelDB jewelFound = jewelService.getJewelById(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<JewelDB> createJewel(@RequestBody JewelDB newJewel) {
        if (newJewel.getId() != 0) return null; // lançar exceção de acordo com o erro

        return ResponseEntity.status(HttpStatus.CREATED).body(jewelService.createNewJewel(newJewel));
    }

    @GetMapping
    public ResponseEntity<List<JewelDB>> getAllJewels() {
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable Long id) {
        JewelDB jewelFound = jewelService.getJewelById(id);
        return ResponseEntity.notFound().build();
    }
}

