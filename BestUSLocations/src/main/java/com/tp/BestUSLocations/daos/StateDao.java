package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.Location;
import com.tp.BestUSLocations.models.State;

import java.util.List;

public interface StateDao {

    public List<State> getAllStates();

    State getSelectedState(State selected);

    State getStateByName(State name);

    State getStateById(State id);

    State getStateByAbrv(State abrv);
}
