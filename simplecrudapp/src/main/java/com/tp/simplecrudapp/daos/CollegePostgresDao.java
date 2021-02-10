package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.daos.mappers.CollegeMapper;
import com.tp.simplecrudapp.daos.mappers.PartialStudentMapper;
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
public class CollegePostgresDao implements  CollegeDao {
    @Autowired
    private JdbcTemplate template;

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




}
