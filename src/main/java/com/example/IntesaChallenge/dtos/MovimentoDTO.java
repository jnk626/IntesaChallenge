package com.example.IntesaChallenge.dtos;

import com.example.IntesaChallenge.model.Movimento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoDTO {
    private long id;
    private double ammontare;
    private LocalDateTime data;
    private String tipologia;
    private String descrizione;
}
