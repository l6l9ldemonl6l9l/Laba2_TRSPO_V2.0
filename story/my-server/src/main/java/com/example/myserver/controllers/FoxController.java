package com.example.myserver.controllers;

import com.example.models.Fox;
import com.example.myserver.repository.FoxRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FoxController {
    private final FoxRepository FoxRepository;

    public FoxController(FoxRepository FoxRepository){
        this.FoxRepository = FoxRepository;
    }

    public void createFox(String name) {
        if(checkExistByName(name))
            throw new IllegalArgumentException("This name number already exists");
        int energy=10;
        int sizeMind=20;
        Date date= new Date();
        Fox fox= new Fox(name, date, energy,sizeMind);
        FoxRepository.save(fox);

        System.out.println("\u001B[33m" + "New Fox"+ fox.getName() +" added" + "\u001B[0m");
    }

    public Fox getFoxByName(String name) throws IllegalArgumentException {
        List<Fox> foundFoxs = FoxRepository.findByName(name);

        if(foundFoxs.size() == 0){
            throw new IllegalArgumentException("Fox not found");
        }

        return foundFoxs.get(0);
    }

    public boolean checkExist(UUID FoxId){
        return FoxRepository.existsById(FoxId);
    }

    public boolean checkExistByName(String name){
        return FoxRepository.existsByName(name);
    }
}

