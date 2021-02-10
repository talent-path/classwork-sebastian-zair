package com.tp.simplecrudapp.daos.mappers;

import com.tp.simplecrudapp.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartialStudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student toReturn = new Student();
        toReturn.setName( resultSet.getString("studentName"));
        toReturn.setStudentId( resultSet.getInt("studentId"));

        return toReturn;
    }
}
