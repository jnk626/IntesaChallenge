package com.example.IntesaChallenge.services;

import com.example.IntesaChallenge.dtos.ContoDTO;
import com.example.IntesaChallenge.mappers.ContoMapper;
import com.example.IntesaChallenge.model.Conto;
import com.example.IntesaChallenge.repositories.ContoRepository;
import com.example.IntesaChallenge.repositories.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContoService extends AbstractService<Conto, ContoDTO> {
    private final ContoRepository repository;
    private final UtenteRepository utenteRepository;
    private final ContoMapper mapper;
    public List<ContoDTO> findByUtente_Id(long id) throws EntityNotFoundException {
        if (utenteRepository.findById(id).isEmpty())
            throw new EntityNotFoundException();
        return mapper.toDTOList(repository.findByUtente_Id(id));
    };

}
