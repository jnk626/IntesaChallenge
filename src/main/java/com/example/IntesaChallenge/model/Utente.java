package com.example.IntesaChallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public final class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "utente")
    @JsonIgnore
    private Set<Conto> conti;
    @OneToOne(mappedBy = "utente")
    @JsonIgnore
    private Anagrafica anagrafica;

}
