package com.tp.simplecrudapp.daos.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//class StudentIdMapper implements RowMapper<Integer> {
//
//    @Override
//    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
//        return resultSet.getInt("StudentId");
//    }
//}

public class IntegerMapper implements RowMapper<Integer>{
    String columnName;

    public IntegerMapper( String columnName ){
        this.columnName = columnName;
    }

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt(columnName);
    }
}
