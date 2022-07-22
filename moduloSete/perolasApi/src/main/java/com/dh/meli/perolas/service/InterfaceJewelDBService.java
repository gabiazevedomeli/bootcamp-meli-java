package com.dh.meli.perolas.service;

import com.dh.meli.perolas.model.JewelDB;

import java.util.List;

public interface InterfaceJewelDBService {

    JewelDB getJewelById(Long id);

    List<JewelDB> getAllJewels();

    JewelDB createNewJewel(JewelDB newJewel);

    JewelDB updateJewel(Long id);

    void deleteJewel(Long id);

}
