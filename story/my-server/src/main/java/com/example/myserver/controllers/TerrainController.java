package com.example.myserver.controllers;

import com.example.models.Terrain;
import com.example.myserver.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TerrainController {
    private final TerrainRepository TerrainRepository;

    public TerrainController(TerrainRepository TerrainRepository){
        this.TerrainRepository = TerrainRepository;
    }

    public void createTerrain(String name) {
        if(checkExistByName(name))
            throw new IllegalArgumentException("This name number already exists");
        int sizeBeauty=10;
        Terrain Terrain= new Terrain(name, sizeBeauty);
        TerrainRepository.save(Terrain);

        System.out.println("\u001B[33m" + "New Terrain"+ Terrain.getName() +" added" + "\u001B[0m");
    }

    public Terrain getTerrainByName(String name) throws IllegalArgumentException {
        List<Terrain> foundTerrain = TerrainRepository.findByName(name);

        if(foundTerrain.size() == 0){
            throw new IllegalArgumentException("Terrain not found");
        }

        return foundTerrain.get(0);
    }

    public boolean checkExist(UUID TerrainId){
        return TerrainRepository.existsById(TerrainId);
    }

    public boolean checkExistByName(String name){
        return TerrainRepository.existsByName(name);
    }
}


