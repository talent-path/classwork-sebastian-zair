package com.tp.simplecrudapp.controllers;

import com.tp.simplecrudapp.models.Student;
import com.tp.simplecrudapp.services.UniversityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    UniversityManagementService service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student toAdd ){

        Student completed = service.addStudent( toAdd );

        return ResponseEntity.ok(completed);
    }



}
