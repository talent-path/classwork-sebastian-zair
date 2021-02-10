package com.tp.simplecrudapp.daos.mappers;

import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student mappedStudent = new Student();
        mappedStudent.setStudentId( resultSet.getInt("studentId") );
        mappedStudent.setName( resultSet.getString( "studentName") );

        College associatedCollege = new College();
        associatedCollege.setCollegeId( resultSet.getInt("collegeId") );
        associatedCollege.setCollegeName( resultSet.getString( "collegeName"));

        mappedStudent.setAssociatedCollege(associatedCollege);

        return mappedStudent;
    }
}