package com.tp.simplecrudapp.services;

import com.tp.simplecrudapp.daos.CollegeDao;
import com.tp.simplecrudapp.daos.StudentDao;
import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityManagementService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    CollegeDao collegeDao;


    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student addStudent(Student toAdd) {
        //TODO: validate that student isn't missing anything

        return studentDao.addStudent( toAdd );
    }

    public College getCollegeById(Integer collegeId ){
        return collegeDao.getById( collegeId );

    }
}
