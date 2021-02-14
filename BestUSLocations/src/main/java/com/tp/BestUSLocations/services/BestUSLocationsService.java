package com.tp.BestUSLocations.services;

import com.tp.BestUSLocations.daos.CityDao;
import com.tp.BestUSLocations.daos.StateDao;
import com.tp.BestUSLocations.models.City;
import com.tp.BestUSLocations.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BestUSLocationsService {

    @Autowired
    StateDao statedao;

    @Autowired
    CityDao citydao;

    public List<State> getAllStates(){
        return statedao.getAllStates();
    }

    public State getSelectedState(State selected) {
        return statedao.getSelectedState(selected);
    }

    public State getStateByName(String name) {
       return statedao.getStateByName(name);
    }

    public State getStateById(Integer id) {
        return statedao.getStateById(id);
    }

    public State getStateByAbrv(String abrv) {
        return statedao.getStateByAbrv(abrv);
    }

    public List<City> getAllCitiesByStateID(Integer stateID) {
        return citydao.getAllCitiesByStateID(stateID);
    }

    public List<City> getAllCitiesByStateName(String stateName) {
        return citydao.getAllCitiesByStateName(stateName);
    }
}
