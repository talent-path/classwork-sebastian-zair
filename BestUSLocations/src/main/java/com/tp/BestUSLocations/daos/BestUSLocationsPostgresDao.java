package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BestUSLocationsPostgresDao implements BestUSLocationsDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Location> getAllLocations(){

        List<Location> allLocations = template.query("SELECT *\n" +
                "FROM \"Locations\"", new LocationMapper());

            return allLocations;
    }

    class LocationMapper implements RowMapper<Location>{

        @Override
        public Location mapRow(ResultSet resultSet, int i) throws SQLException {
            Location mappedLocation = new Location();
            mappedLocation.setLocationID(resultSet.getInt("locationID"));
            mappedLocation.setLocationName(resultSet.getString("locationName"));

            return mappedLocation;

        }
    }
}
