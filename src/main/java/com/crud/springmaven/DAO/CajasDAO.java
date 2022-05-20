package com.crud.springmaven.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springmaven.DTO.Cajas;

@Repository
public interface CajasDAO extends JpaRepository<Cajas, String> {

}