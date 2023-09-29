package com.example.IntesaChallenge.repositories;

import com.example.IntesaChallenge.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    public Utente findByUsername(String username);
}
