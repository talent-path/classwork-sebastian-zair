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

    // methods to add:
    // 1.) Get information for 1 single city if name, or id of city is provided (instead of a list)
    // 2.) Add a city to a state
    // 3.) Delete a city from a state
    // 4.) Update a city of a state - ie with new locations

    @Autowired
    BestUSLocationsService service;

    @GetMapping("/cities/{stateID}")
    public ResponseEntity<List<City>> getAllCitiesByStateID(@PathVariable Integer stateID){

        List<City> citiesInState = service.getAllCitiesByStateID(stateID);

        return ResponseEntity.ok(citiesInState);
    }

    @GetMapping("/cities/byname/{stateName}") // ask how to have similar parameters but differnt values for the URL mapping..
    public ResponseEntity<List<City>> getAllCitiesByStateName(@PathVariable String stateName){

        List<City> statesName = service.getAllCitiesByStateName(stateName);

        return ResponseEntity.ok(statesName);
    }

    @GetMapping("/cities/byabrv/{stateAbrv}")
    public ResponseEntity<List<City>> getAllCitiesByStateAbrv(@PathVariable String stateAbrv){

        List<City> statesAbrv = service.getAllStatesByStateAbrv(stateAbrv);

        return ResponseEntity.ok(statesAbrv);
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<City> getCityDetailsByName(@PathVariable String cityName){
        City cityByName = service.getCityDetailsByName(cityName);

        return ResponseEntity.ok(cityByName);
    }

    @GetMapping("/city/id/{cityID}")
    public ResponseEntity<City> getCityDetailsByID(@PathVariable Integer cityID) {
        City cityByID = service.getCityDeatailsByID(cityID);

        return ResponseEntity.ok(cityByID);
    }
}
