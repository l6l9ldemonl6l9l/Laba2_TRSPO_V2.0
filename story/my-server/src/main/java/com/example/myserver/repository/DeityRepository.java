package com.example.myserver.repository;

import com.example.models.Deity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface DeityRepository extends CrudRepository <Deity, Long > {
    List<Deity> findByName(String name);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
