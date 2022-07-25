package com.dh.meli.perolas.service;

import com.dh.meli.perolas.model.JewelDB;

import java.util.List;
import java.util.Map;

public interface InterfaceJewelDBService {

    JewelDB getJewelById(Long id);

    List<JewelDB> getAllJewels();

    JewelDB createNewJewel(JewelDB newJewel);

    JewelDB updateJewel(JewelDB newJewelInfo);

    JewelDB updatePartialJewel(Long id, Map<String, ?> changes);

    void deleteJewel(Long id);

}
