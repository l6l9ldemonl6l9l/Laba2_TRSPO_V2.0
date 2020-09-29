package com.example.myserver.repository;

import com.example.models.Terrain;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

public interface TerrainRepository extends CrudRepository <Terrain, Long > {
    List<Terrain> findByName(String name);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
