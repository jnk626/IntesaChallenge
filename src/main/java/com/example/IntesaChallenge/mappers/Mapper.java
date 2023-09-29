package com.example.IntesaChallenge.mappers;

import java.util.List;

public interface Mapper<Entity, DTO> {
    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);
    List<DTO> toDTOList(Iterable<Entity> list);
    List<Entity> toEntityList(Iterable<DTO> list);
}
