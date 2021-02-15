package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.City;
import com.tp.BestUSLocations.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CityPostgresDao implements CityDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<City> getAllCitiesByStateID(Integer stateID) {
        List<City>  allCitiesInState = template.query("SELECT *\n" +
                "FROM \"Cities\" c JOIN \"States\" s ON c.\"stateID\" = s.\"stateID\"\n" +
                "WHERE s.\"stateID\" = '" + stateID + "'", new CityMapper());

        return allCitiesInState;
    }

    @Override
    public List<City> getAllCitiesByStateName(String stateName) {
        List<City>  allCitiesInStateByName = template.query("SELECT *\n" +
                "FROM \"Cities\" c JOIN \"States\" s ON c.\"stateID\" = s.\"stateID\"\n" +
                "WHERE s.\"stateName\" = '" + stateName + "'", new CityMapper());

        return allCitiesInStateByName;
    }

    @Override
    public List<City> getAllStateByStateAbrv(String stateAbrv) {
        List<City>  allCitiesInStateByAbrv = template.query("SELECT *\n" +
                "FROM \"Cities\" c JOIN \"States\" s ON c.\"stateID\" = s.\"stateID\"\n" +
                "WHERE s.\"stateAbrv\" = '" + stateAbrv + "'", new CityMapper());

        return allCitiesInStateByAbrv;
    }

    @Override
    public City getCityDetailsByName(String cityName) {
        City cityDetesByName = template.queryForObject("SELECT *\n" +
                "FROM \"Cities\" c\n" +
                "WHERE c.\"cityName\" = '" + cityName + "'", new CityMapper());

        return cityDetesByName;
    }

    @Override
    public City getCityDetailsByID(Integer cityID) {
       City cityDetesByID =  template.queryForObject("SELECT *\n" +
                "FROM \"Cities\" c\n" +
                "WHERE c.\"cityID\" = '" + cityID + "'", new CityMapper());

        return cityDetesByID;
    }

    public class CityMapper implements RowMapper<City> {

        @Override
        public City mapRow(ResultSet resultSet, int i) throws SQLException {

            State mappedState = new State();
            City mappedCity = new City();


            mappedCity.setCityID(resultSet.getInt("cityID"));
            mappedCity.setCityName(resultSet.getString("cityName"));
            mappedState.setStateID(resultSet.getInt("stateID"));


            return mappedCity;
        }
    }
}
