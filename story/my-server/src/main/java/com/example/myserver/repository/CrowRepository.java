package com.example.myserver.repository;

import com.example.models.Crow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CrowRepository extends CrudRepository <Crow, Long > {
    List<Crow> findByName(String name);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
