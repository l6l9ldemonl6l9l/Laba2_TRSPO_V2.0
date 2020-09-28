package com.example.myserver.repository;

import com.example.models.Terrain;
import org.springframework.data.repository.CrudRepository;

public interface TerrainRepository extends CrudRepository<Terrain, Long> {

    Terrain findByName(String name);
}
