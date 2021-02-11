package com.tp.BestUSLocations.controllers;

import com.tp.BestUSLocations.models.Location;
import com.tp.BestUSLocations.models.State;
import com.tp.BestUSLocations.services.BestUSLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BestUSLocationsController {

    @Autowired
    BestUSLocationsService service;

    @GetMapping("/states")
    public ResponseEntity<List<State>> allStates(){
        List<State> as = service.getAllStates();

        return ResponseEntity.ok(as);

    }

}
