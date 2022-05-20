package com.crud.springmaven.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springmaven.DTO.Almacenes;

@Repository
public interface AlmacenesDAO extends JpaRepository<Almacenes, Long> {

}