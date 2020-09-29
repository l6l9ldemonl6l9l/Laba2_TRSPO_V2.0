package com.example.myserver.rest;

import com.example.myserver.controllers.TerrainController;
import com.example.models.Terrain;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terrain")
public class TerrainRest {
    private final TerrainController TerrainController;

    public TerrainRest(TerrainController TerrainController) {
        this.TerrainController = TerrainController;
    }

    @PostMapping("/Terrains")
    public ResponseEntity<String> newClient(@RequestParam String name) {
        try{
            TerrainController.createTerrain(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/Terrains",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTerrain(@RequestParam String name) {
        Terrain foundTerrain;
        try {
            foundTerrain = TerrainController.getTerrainByName(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(foundTerrain, HttpStatus.OK);
    }
}
