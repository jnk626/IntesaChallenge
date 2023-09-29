package com.example.IntesaChallenge.services;

import com.example.IntesaChallenge.mappers.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<Entity,DTO> implements Service<DTO>{
    @Autowired
    protected JpaRepository<Entity, Long> repository;
    @Autowired
    protected Mapper<Entity, DTO> mapper;

    @Override
    public DTO findById(long id) throws EntityNotFoundException {
        if (repository.findById(id).isEmpty())
                throw new EntityNotFoundException();
        return mapper.toDTO(repository.findById(id).get());
    }
}
