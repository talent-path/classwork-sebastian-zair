package com.tp.BestUSLocations.models;

public class City {

    Integer cityID;
    String cityName;
    State state;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



}
