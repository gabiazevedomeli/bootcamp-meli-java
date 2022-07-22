package com.dh.meli.perolas.repository;

import com.dh.meli.perolas.model.JewelDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceJewelDBRepository extends CrudRepository<JewelDB, Long> {
}
