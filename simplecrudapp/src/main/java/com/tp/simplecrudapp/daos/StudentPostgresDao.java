package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentPostgresDao implements StudentDao {

    @Autowired
    JdbcTemplate template;

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
                new StudentIdMapper(),
                toAdd.getName(),
                toAdd.getAssociatedCollege().getCollegeId()
        );

        toAdd.setStudentId( studentId );

        return toAdd;
    }

    class StudentMapper implements RowMapper<Student>{

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

    class StudentIdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("StudentId");
        }
    }
}
