package com.tp.BestUSLocations.controllers;

import com.tp.BestUSLocations.models.City;
import com.tp.BestUSLocations.services.BestUSLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    BestUSLocationsService service;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCitiesByStateID(@PathVariable Integer stateID){

        List<City> citiesInState = service.getAllCitiesByStateID(stateID);

        return ResponseEntity.ok(citiesInState);
    }
}
