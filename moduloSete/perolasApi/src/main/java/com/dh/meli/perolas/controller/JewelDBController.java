package com.dh.meli.perolas.controller;

import com.dh.meli.perolas.model.JewelDB;
import com.dh.meli.perolas.service.JewelDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/jewels")
public class JewelDBController {

    @Autowired
    private JewelDBService jewelService;

    @GetMapping("/{id}")
    public ResponseEntity<JewelDB> getJewelById(@PathVariable Long id) {
        return ResponseEntity.ok(jewelService.getJewelById(id));
    }

    @PostMapping
    public ResponseEntity<JewelDB> createNewJewel(@RequestBody @Valid JewelDB newJewel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jewelService.createNewJewel(newJewel));
    }

    @GetMapping
    public ResponseEntity<List<JewelDB>> getAllJewels() {
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @PutMapping
    public ResponseEntity<JewelDB> updateJewel(@Valid @RequestBody JewelDB newJewelInfo) {
        return ResponseEntity.ok(jewelService.updateJewel(newJewelInfo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JewelDB> updatePartialJewel(@PathVariable Long id, @Valid @RequestBody Map<String, ?> changes) {
        return ResponseEntity.ok(jewelService.updatePartialJewel(id, changes));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable Long id) {
        jewelService.deleteJewel(id);
        return ResponseEntity.noContent().build();
    }
}

