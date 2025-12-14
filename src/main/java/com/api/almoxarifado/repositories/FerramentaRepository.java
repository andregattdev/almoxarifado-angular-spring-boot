package com.api.almoxarifado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.almoxarifado.models.Ferramenta;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Long> {
}