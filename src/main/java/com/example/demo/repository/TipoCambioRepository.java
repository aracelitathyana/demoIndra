package com.example.demo.repository;

import com.example.demo.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository <TipoCambio, Long> {
}
