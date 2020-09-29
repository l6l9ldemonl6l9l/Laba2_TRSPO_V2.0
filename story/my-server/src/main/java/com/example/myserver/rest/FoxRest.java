package com.example.myserver.rest;

import com.example.myserver.controllers.FoxController;
import com.example.models.Fox;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fox")
public class FoxRest {
    private final FoxController FoxController;

    public FoxRest(FoxController FoxController) {
        this.FoxController = FoxController;
    }

    @PostMapping("/Fox")
    public ResponseEntity<String> newClient(@RequestParam String name) {
        try{
            FoxController.createFox(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/Fox",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getFox(@RequestParam String name) {
        Fox foundFox;
        try {
            foundFox = FoxController.getFoxByName(name);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>("Bad Request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e ){
            return new ResponseEntity<>("Server Error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(foundFox, HttpStatus.OK);
    }
}
