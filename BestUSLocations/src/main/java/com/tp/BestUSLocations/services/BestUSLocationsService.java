package com.tp.BestUSLocations.services;

import com.tp.BestUSLocations.daos.BestUSLocationsDao;
import com.tp.BestUSLocations.models.Location;
import com.tp.BestUSLocations.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BestUSLocationsService {

    @Autowired
    BestUSLocationsDao dao;

    public List<State> getAllStates(){
        return dao.getAllStates();
    }
}
