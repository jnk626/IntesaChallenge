package com.example.IntesaChallenge.mappers;

import com.example.IntesaChallenge.dtos.UtenteDTO;
import com.example.IntesaChallenge.model.Utente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtenteMapper implements Mapper<Utente, UtenteDTO>{
    @Override
    public UtenteDTO toDTO(Utente utente) {
        return UtenteDTO.builder()
                .id(utente.getId())
                .username(utente.getUsername())
                .password(utente.getPassword())
                .build();
    }

    @Override
    public Utente toEntity(UtenteDTO utenteDTO) {
        return Utente.builder()
                .id(utenteDTO.getId())
                .username(utenteDTO.getUsername())
                .password(utenteDTO.getPassword())
                .build();
    }

    @Override
    public List<UtenteDTO> toDTOList(Iterable<Utente> list) {
        return ((List<Utente>) list).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<Utente> toEntityList(Iterable<UtenteDTO> list) {
        return ((List<UtenteDTO>) list).stream().map(this::toEntity).collect(Collectors.toList());
    }
}
