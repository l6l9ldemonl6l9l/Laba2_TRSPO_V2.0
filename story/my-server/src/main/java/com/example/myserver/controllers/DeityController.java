package com.example.myserver.controllers;

import com.example.models.Deity;
import com.example.myserver.repository.DeityRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DeityController {
    private final DeityRepository DeityRepository;

    public DeityController(DeityRepository DeityRepository){
        this.DeityRepository = DeityRepository;
    }

    public void createDeity(String name) {
        if(checkExistByName(name))
            throw new IllegalArgumentException("This name number already exists");
        Date date= new Date();
        Deity Deity= new Deity(name, date);
        DeityRepository.save(Deity);

        System.out.println("\u001B[33m" + "New Deity"+ Deity.getName() +" added" + "\u001B[0m");
    }

    public Deity getDeityByName(String name) throws IllegalArgumentException {
        List<Deity> foundDeity = DeityRepository.findByName(name);

        if(foundDeity.size() == 0){
            throw new IllegalArgumentException("Deity not found");
        }

        return foundDeity.get(0);
    }

    public boolean checkExist(UUID DeityId){
        return DeityRepository.existsById(DeityId);
    }

    public boolean checkExistByName(String name){
        return DeityRepository.existsByName(name);
    }
}


