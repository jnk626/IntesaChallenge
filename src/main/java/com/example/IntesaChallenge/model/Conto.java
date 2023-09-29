package com.example.IntesaChallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Conto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    private double bilancio;
    private char valuta;
    private String IBAN;
    @ManyToOne
    private Utente utente;
    @OneToMany(mappedBy = "conto")
    private Set<Movimento> movimento;
}
