package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();

    Student addStudent(Student toAdd);
}
