package com.example.myserver.repository;

import com.example.models.Fox;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FoxRepository extends CrudRepository <Fox, Long > {
    List<Fox> findByName(String name);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
