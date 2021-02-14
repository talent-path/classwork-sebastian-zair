package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityPostgresDao implements CityDao{

    JdbcTemplate template;

    @Override
    public List<City> getAllCitiesByStateID(Integer stateID) {
        List<City>  allCitiesInState = template.query("SELECT *\n" +
                "FROM \"Cities\" c JOIN \"States\" s ON c.\"stateID\" = s.\"stateID\"\n" +
                "WHERE s.\"stateID\" = '1'", new CityMapper());

        return allCitiesInState;
    }

    public class CityMapper implements RowMapper<City> {

        @Override
        public City mapRow(ResultSet resultSet, int i) throws SQLException {

            City mappedCity = new City();

            mappedCity.setCityID(resultSet.getInt("cityID"));
            mappedCity.setCityName(resultSet.getString("cityName"));
            //mappedCity.setState();

            return mappedCity;
        }
    }
}
