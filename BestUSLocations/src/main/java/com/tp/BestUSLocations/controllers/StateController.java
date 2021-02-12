package com.tp.BestUSLocations.controllers;

import com.tp.BestUSLocations.models.State;
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
public class StateController {

    @Autowired
    BestUSLocationsService service;

    @GetMapping("/states")
    public ResponseEntity<List<State>> allStates(){
        List<State> as = service.getAllStates();

        return ResponseEntity.ok(as);

    }

    @GetMapping("/state")
    public ResponseEntity<State> selectState(State selected){
        State selectedState = service.getSelectedState(selected);

        return ResponseEntity.ok(selectedState);
    }

    @GetMapping("/statename/{name}")
    public ResponseEntity<State> stateByName(@PathVariable String name){
        State stateName = service.getStateByName(name);

        return ResponseEntity.ok(stateName);
    }

    @GetMapping("/stateid/{id}")
    public ResponseEntity<State> stateByID(@PathVariable Integer id){
        State stateID = service.getStateById(id);

        return ResponseEntity.ok(stateID);
    }
    @GetMapping("/stateabrv/{abrv}")
    public ResponseEntity<State> stateByAbrv(@PathVariable String abrv){
       State abrvState = service.getStateByAbrv(abrv);

       return ResponseEntity.ok(abrvState);
    }
}
