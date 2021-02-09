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
public class CollegePostgresDao implements  CollegeDao {
    @Autowired
    JdbcTemplate template;

    @Override
    public College getById(Integer collegeId) {

        College incomplete = template.queryForObject(
                "SELECT \"collegeId\", \"collegeName\" FROM \"Colleges\"", new CollegeMapper() );

        getStudentsByCollegeId(incomplete);

        return incomplete;
    }


    //TODO: check if the interface should have this method
    public List<Student> getStudentsByCollegeId(College parentCollege ){

        List<Student> allStudents = template.query(
                "SELECT * FROM \"Students\" WHERE \"Students\".\"collegeId\" = ?",
                new PartialStudentMapper(),
                parentCollege.getCollegeId());

        parentCollege.setAllStudents( allStudents );
//        for( Student toUpdate : allStudents ){
//            toUpdate.setAssociatedCollege(parentCollege);
//        }

        return allStudents;
    }

    class PartialStudentMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student toReturn = new Student();
            toReturn.setName( resultSet.getString("studentName"));
            toReturn.setStudentId( resultSet.getInt("studentId"));

            return toReturn;
        }
    }

    class CollegeMapper implements RowMapper<College>{


        @Override
        public College mapRow(ResultSet resultSet, int i) throws SQLException {
            College toReturn = new College();

            toReturn.setCollegeId( resultSet.getInt("collegeId") );
            toReturn.setCollegeName(resultSet.getString("collegeName"));

            return toReturn;
        }
    }
}
