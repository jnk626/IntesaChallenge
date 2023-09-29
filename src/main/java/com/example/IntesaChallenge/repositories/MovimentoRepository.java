package com.example.IntesaChallenge.repositories;

import com.example.IntesaChallenge.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    List<Movimento> findByConto_Id(Long id);
}
