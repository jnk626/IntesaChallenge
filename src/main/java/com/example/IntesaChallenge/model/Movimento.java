package com.example.IntesaChallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private double ammontare;
    private LocalDateTime data;
    public enum Tipologia {
        ENTRATA, USCITA
    }
    @Enumerated(EnumType.STRING)
    private Tipologia tipologia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Conto conto;
}
