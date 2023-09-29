package com.example.IntesaChallenge.mappers;

import com.example.IntesaChallenge.dtos.ContoDTO;
import com.example.IntesaChallenge.model.Conto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContoMapper implements Mapper<Conto, ContoDTO> {
    @Override
    public ContoDTO toDTO(Conto conto) {
        return ContoDTO.builder()
                .id(conto.getId())
                .nome(conto.getNome())
                .bilancio(conto.getBilancio())
                .valuta(conto.getValuta())
                .IBAN(conto.getIBAN())
                .build();
    }

    @Override
    public Conto toEntity(ContoDTO contoDTO) {
        return Conto.builder()
                .id(contoDTO.getId())
                .nome(contoDTO.getNome())
                .bilancio(contoDTO.getBilancio())
                .valuta(contoDTO.getValuta())
                .IBAN(contoDTO.getIBAN())
                .build();
    }

    @Override
    public List<ContoDTO> toDTOList(Iterable<Conto> list) {
        return ((List<Conto>) list).stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<Conto> toEntityList(Iterable<ContoDTO> list) {
        return ((List<ContoDTO>) list).stream()
                .map(this::toEntity)
                .toList();
    }
}
