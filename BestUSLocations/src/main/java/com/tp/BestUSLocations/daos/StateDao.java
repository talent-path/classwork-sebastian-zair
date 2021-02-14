package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.City;
import com.tp.BestUSLocations.models.Location;
import com.tp.BestUSLocations.models.State;

import java.util.List;

public interface StateDao {

    public List<State> getAllStates();

    State getSelectedState(State selected);

    State getStateByName(String name);

    State getStateById(Integer id);

    State getStateByAbrv(String abrv);
}
