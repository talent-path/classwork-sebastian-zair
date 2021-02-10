package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.daos.mappers.IntegerMapper;
import com.tp.simplecrudapp.daos.mappers.StudentMapper;
import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile({"production","daoTesting"})
public class StudentPostgresDao implements StudentDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Student> getAllStudents(){

        List<Student> allStudents = template.query("SELECT \"studentId\", \"studentName\", \"Students\".\"collegeId\", \"collegeName\" FROM \"Students\"\n" +
                "INNER JOIN \"Colleges\" ON \"Students\".\"collegeId\" = \"Colleges\".\"collegeId\"\n" +
                ";", new StudentMapper() );

        return allStudents;
    }

    @Override
    public Student addStudent(Student toAdd) {

        Integer studentId = template.queryForObject(
                "INSERT INTO \"Students\" (\"studentName\", \"collegeId\") VALUES (?, ?) RETURNING \"studentId\";",
                new IntegerMapper("StudentId"),
                toAdd.getName(),
                toAdd.getAssociatedCollege().getCollegeId()
        );

        toAdd.setStudentId( studentId );

        return toAdd;
    }




}
