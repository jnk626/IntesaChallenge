package com.example.IntesaChallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContoDTO {
    private long id;
    private String nome;
    private double bilancio;
    private char valuta;
    private String IBAN;
}
