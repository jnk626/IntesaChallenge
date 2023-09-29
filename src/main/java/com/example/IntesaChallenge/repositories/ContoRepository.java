package com.example.IntesaChallenge.repositories;

import com.example.IntesaChallenge.model.Conto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContoRepository extends JpaRepository<Conto, Long> {
    List<Conto> findByUtente_Id(Long id);
}
