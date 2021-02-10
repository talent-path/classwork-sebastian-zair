package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.Location;
import com.tp.BestUSLocations.models.State;
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
    public List<State> getAllLocations(){

        List<State> allStates = template.query("SELECT * \n" +
                "FROM \"States\"", new StateMapper());

            return allStates;
    }

    class StateMapper implements RowMapper<State>{

        @Override
        public State mapRow(ResultSet resultSet, int i) throws SQLException {
            State mappedState = new State();
            mappedState.setStateID(resultSet.getInt("stateID"));
            mappedState.setStateName(resultSet.getString("stateName"));
            mappedState.setStateAbrv(resultSet.getString("stateAbrv"));


            return mappedState;

        }
    }
}
