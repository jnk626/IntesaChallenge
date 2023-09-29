package com.example.IntesaChallenge.services;

import com.example.IntesaChallenge.dtos.MovimentoDTO;
import com.example.IntesaChallenge.mappers.MovimentoMapper;
import com.example.IntesaChallenge.model.Conto;
import com.example.IntesaChallenge.model.Movimento;
import com.example.IntesaChallenge.repositories.ContoRepository;
import com.example.IntesaChallenge.repositories.MovimentoRepository;
import com.example.IntesaChallenge.repositories.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovimentoService extends AbstractService<Movimento, MovimentoDTO> {
    private final MovimentoRepository repository;
    private final ContoRepository contoRepository;
    private final UtenteRepository utenteRepository;
    private final MovimentoMapper mapper;
    public List<MovimentoDTO> getAllMovementsByUserId(long id) throws EntityNotFoundException {
        if (utenteRepository.findById(id).isEmpty())
            throw new EntityNotFoundException();
        return mapper.toDTOList(contoRepository.findByUtente_Id(id).stream()
                .flatMap(conto -> repository.findByConto_Id(conto.getId()).stream())
                .toList());
    }
}
