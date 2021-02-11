package com.tp.BestUSLocations.services;

import com.tp.BestUSLocations.daos.StateDao;
import com.tp.BestUSLocations.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BestUSLocationsService {

    @Autowired
    StateDao dao;

    public List<State> getAllStates(){
        return dao.getAllStates();
    }

    public State getSelectedState(State selected) {
        return dao.getSelectedState(selected);
    }

    public State getStateByName(State name) {
       return dao.getStateByName(name);
    }

    public State getStateById(State id) {
        return dao.getStateById(id);
    }
}
