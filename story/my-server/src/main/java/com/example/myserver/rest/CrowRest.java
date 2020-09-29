package com.example.myserver.rest;

import com.example.models.Crow;
import com.example.myserver.controllers.CrowController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CrowRest{
    private final CrowController crowController;

    public CrowRest(CrowController crowController) {
        this.crowController = crowController;
    }

    @PostMapping("/crowsPost")
    public ResponseEntity<String> newCrow(@RequestParam String name, @RequestParam int energy, @RequestParam int sizeMind) {
        try{
            crowController.createCrow(name,energy,sizeMind);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request1: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error1: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Created1", HttpStatus.CREATED);
    }

    @GetMapping(value = "/crowsGet",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCrow(@RequestParam String name) {
        Crow foundCrow;
        try {
            foundCrow = crowController.getCrowByName(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(foundCrow, HttpStatus.OK);
    }


}
