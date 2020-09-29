package com.example.myserver.rest;

import com.example.myserver.controllers.DeityController;
import com.example.models.Deity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deity")
public class DeityRest {
    private final DeityController DeityController;

    public DeityRest(DeityController DeityController) {
        this.DeityController = DeityController;
    }

    @PostMapping("/Deity")
    public ResponseEntity<String> newClient(@RequestParam String name) {
        try{
            DeityController.createDeity(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/Deity",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getDeity(@RequestParam String name) {
        Deity foundDeity;
        try {
            foundDeity = DeityController.getDeityByName(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(foundDeity, HttpStatus.OK);
    }
}
