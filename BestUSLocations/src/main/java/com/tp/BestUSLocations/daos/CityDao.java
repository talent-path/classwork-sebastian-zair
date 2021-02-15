package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.City;

import java.util.List;

public interface CityDao {

    public List<City> getAllCitiesByStateID(Integer stateID);

    List<City> getAllCitiesByStateName(String stateName);

    List<City> getAllStateByStateAbrv(String stateAbrv);

    City getCityDetailsByName(String cityName);
}
