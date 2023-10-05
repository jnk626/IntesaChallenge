package com.example.IntesaChallenge.mappers;

import com.example.IntesaChallenge.dtos.MovimentoDTO;
import com.example.IntesaChallenge.model.Movimento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovimentoMapper implements Mapper<Movimento, MovimentoDTO> {
    @Override
    public MovimentoDTO toDTO(Movimento movimento) {
        return MovimentoDTO.builder()
                .id(movimento.getId())
                .ammontare(movimento.getAmmontare())
                .data(movimento.getData())
                .tipologia(String.valueOf(movimento.getTipologia()))
                .descrizione(movimento.getDescrizione())
                .build();
    }

    @Override
    public Movimento toEntity(MovimentoDTO movimentoDTO) {
        return Movimento.builder()
                .id(movimentoDTO.getId())
                .ammontare(movimentoDTO.getAmmontare())
                .data(movimentoDTO.getData())
                .tipologia(Movimento.Tipologia.valueOf(movimentoDTO.getTipologia()))
                .descrizione(movimentoDTO.getDescrizione())
                .build();
    }

    @Override
    public List<MovimentoDTO> toDTOList(Iterable<Movimento> list) {
        return ((List<Movimento>) list).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<Movimento> toEntityList(Iterable<MovimentoDTO> list) {
        return ((List<MovimentoDTO>) list).stream().map(this::toEntity).collect(Collectors.toList());
    }
}
