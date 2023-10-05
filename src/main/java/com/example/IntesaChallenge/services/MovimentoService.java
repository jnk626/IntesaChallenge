package com.example.IntesaChallenge.services;

import com.example.IntesaChallenge.dtos.MovimentoDTO;
import com.example.IntesaChallenge.mappers.MovimentoMapper;
import com.example.IntesaChallenge.model.Movimento;
import com.example.IntesaChallenge.repositories.ContoRepository;
import com.example.IntesaChallenge.repositories.MovimentoRepository;
import com.example.IntesaChallenge.repositories.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentoService extends AbstractService<Movimento, MovimentoDTO> {
    private final MovimentoRepository repository;
    private final ContoRepository contoRepository;
    private final UtenteRepository utenteRepository;
    private final MovimentoMapper mapper;
    public List<MovimentoDTO> getAllMovementsByContoId(long id) throws EntityNotFoundException {
        if (!contoRepository.existsById(id))
            throw new EntityNotFoundException();
        return mapper.toDTOList(repository.findByConto_Id(id));
    }
}
