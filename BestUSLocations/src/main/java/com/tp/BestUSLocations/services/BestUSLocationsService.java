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

    public State getStateByName(String name) {
       return dao.getStateByName(name);
    }

    public State getStateById(Integer id) {
        return dao.getStateById(id);
    }

    public State getStateByAbrv(String abrv) {
        return dao.getStateByAbrv(abrv);
    }
}
