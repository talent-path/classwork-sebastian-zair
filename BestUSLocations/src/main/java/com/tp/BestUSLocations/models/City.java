package com.tp.BestUSLocations.models;

public class City {

    Integer cityID;
    String cityName;
    State stateID;

    public Integer getCityID() {
        return cityID;
    }


    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getStateID() {
        return stateID;
    }

    public void setStateID(State stateID) {
        this.stateID = stateID;
    }


}
