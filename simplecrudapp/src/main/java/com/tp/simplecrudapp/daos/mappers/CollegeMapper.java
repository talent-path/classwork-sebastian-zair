package com.tp.simplecrudapp.daos.mappers;

import com.tp.simplecrudapp.models.College;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollegeMapper implements RowMapper<College> {


    @Override
    public College mapRow(ResultSet resultSet, int i) throws SQLException {
        College toReturn = new College();

        toReturn.setCollegeId( resultSet.getInt("collegeId") );
        toReturn.setCollegeName(resultSet.getString("collegeName"));

        return toReturn;
    }
}
