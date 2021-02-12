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
        // serve as a reminder
        return null;
    }

    @Override
    public State getStateByName(State name) {
        // go on and get the name of your state
        // if you can not do this it's because you do not have a field variable that will let you
        // so if you have not already done so please be sure to get that field variable
        return null;
    }

    @Override
    public State getStateById(State id) {
        // obtain the ID of a State..
        // grab State id through its field variable
        // WHICH ID? That's for the parameter to decide!
        return null;
    }

    @Override
    public State getStateByAbrv(State abrv) {
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
