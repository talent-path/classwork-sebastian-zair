package com.tp.BestUSLocations.services;

import com.tp.BestUSLocations.daos.BestUSLocationsDao;
import com.tp.BestUSLocations.models.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BestUSLocationsService {

    @Autowired
    BestUSLocationsDao dao;

    public List<Location> getAllLocations(){
        return dao.getAllLocations();
    }
}
