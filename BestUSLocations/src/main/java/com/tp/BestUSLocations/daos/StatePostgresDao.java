package com.tp.BestUSLocations.daos;

import com.tp.BestUSLocations.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StatePostgresDao implements StateDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<State> getAllStates(){

        List<State> allStates = template.query("SELECT * \n" +
                "FROM \"States\"", new StateMapper());

            return allStates;
    }

    @Override
    public State getSelectedState(State selected) {
        return null;
    }

    @Override
    public State getStateByName(State name) {
        return null;
    }

    @Override
    public State getStateById(State id) {
        return null;
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
