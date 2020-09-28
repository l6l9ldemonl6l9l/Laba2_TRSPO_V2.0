package com.example.myserver.repository;

import com.example.models.Crow;
import org.springframework.data.repository.CrudRepository;

public interface CrowRepository extends CrudRepository<Crow, Long> {

    Crow findByName(String name);
}
