package com.tp.BestUSLocations.controllers;

import com.tp.BestUSLocations.models.Location;
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

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> allLocations(){
        List<Location> al = service.getAllLocations();

        return ResponseEntity.ok(al);

    }
}
