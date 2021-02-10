package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("serviceTest")
public class StudentInMemDao implements StudentDao {
    @Override
    public List<Student> getAllStudents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student addStudent(Student toAdd) {
        throw new UnsupportedOperationException();
    }
}
