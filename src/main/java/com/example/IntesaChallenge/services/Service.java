package com.example.IntesaChallenge.services;

import java.util.List;
import java.util.Optional;

public interface Service<DTO> {
    DTO findById(long id);
}
