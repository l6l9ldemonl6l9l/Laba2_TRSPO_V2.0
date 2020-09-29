package com.example.myserver.controllers;

import com.example.myserver.repository.CrowRepository;
import com.example.models.Crow;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CrowController {
    private final CrowRepository CrowRepository;

    public CrowController(CrowRepository CrowRepository){
        this.CrowRepository = CrowRepository;
    }

    public void createCrow(String name, int energy, int sizeMind ) {
        if(checkExistByName(name))
            throw new IllegalArgumentException("This name number already exists");
        Date date= new Date();
        Crow crow= new Crow(name, date, energy,sizeMind);
        CrowRepository.save(crow);
        System.out.println("\u001B[33m" + "New crow"+ crow.getName() +" added" + "\u001B[0m");
    }

    public Crow getCrowByName(String name) throws IllegalArgumentException {
        List<Crow> foundCrows = CrowRepository.findByName(name);

        if(foundCrows.size() == 0){
            throw new IllegalArgumentException("Crow not found");
        }

        return foundCrows.get(0);
    }

    public boolean checkExist(UUID crowId){
        return CrowRepository.existsById(crowId);
    }

    public boolean checkExistByName(String name){
        return CrowRepository.existsByName(name);
    }
}


