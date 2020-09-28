package com.example.myserver.repository;

import com.example.models.Deity;
import org.springframework.data.repository.CrudRepository;

public interface DeityRepository extends CrudRepository<Deity, Long> {

    Deity findByName(String name);
}
