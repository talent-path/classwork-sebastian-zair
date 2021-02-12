package com.tp.BestUSLocations.controllers;

import com.tp.BestUSLocations.services.BestUSLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    BestUSLocationsService service;
}
