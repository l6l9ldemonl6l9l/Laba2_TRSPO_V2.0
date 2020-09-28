package com.example.myserver.repository;

import com.example.models.Fox;
import org.springframework.data.repository.CrudRepository;

public interface FoxRepository extends CrudRepository<Fox, Long> {

    Fox findByName(String name);
}
