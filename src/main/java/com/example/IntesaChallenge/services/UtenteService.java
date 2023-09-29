package com.example.IntesaChallenge.services;

import com.example.IntesaChallenge.dtos.UtenteDTO;
import com.example.IntesaChallenge.mappers.UtenteMapper;
import com.example.IntesaChallenge.model.Utente;
import com.example.IntesaChallenge.repositories.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteService extends AbstractService<Utente, UtenteDTO> {
    private final UtenteRepository repository;
    private final UtenteMapper mapper;
    public UtenteDTO findByUsername(String username) throws EntityNotFoundException {
        if (repository.findByUsername(username) == null)
            throw new EntityNotFoundException();
        return mapper.toDTO(repository.findByUsername(username));
    }
}
