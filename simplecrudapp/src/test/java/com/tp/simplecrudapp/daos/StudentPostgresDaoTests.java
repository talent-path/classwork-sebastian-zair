package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("daoTesting")
public class StudentPostgresDaoTests {

    @Autowired
    StudentPostgresDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup(){

        //need to clear all tables and reset all sequences

        template.update("TRUNCATE \"StudentCourses\", \"Courses\", \"Students\", \"Colleges\" RESTART IDENTITY;");

        template.update( "INSERT INTO \"Colleges\" (\"collegeName\") VALUES ('MIT')" );
    }

    @Test
    public void addStudentGoldenPathTest(){

        College mit = new College();
        mit.setCollegeId(1);

        Student partialStudentToAdd = new Student();
        partialStudentToAdd.setAssociatedCollege(mit);
        partialStudentToAdd.setName("Bob");

        Student returned = toTest.addStudent( partialStudentToAdd );

        assertEquals( 1, returned.getStudentId() );
        assertEquals( "Bob", returned.getName() );
        assertEquals( 1, returned.getAssociatedCollege().getCollegeId() );

        List<Student> allStudents = toTest.getAllStudents();

        assertEquals( 1, allStudents.get(0).getStudentId() );
        assertEquals( "Bob", allStudents.get(0).getName() );
        assertEquals( 1, allStudents.get(0).getAssociatedCollege().getCollegeId() );

    }

}
