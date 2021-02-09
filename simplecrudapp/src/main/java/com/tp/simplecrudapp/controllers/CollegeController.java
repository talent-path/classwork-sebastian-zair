package com.tp.simplecrudapp.controllers;

import com.tp.simplecrudapp.models.College;
import com.tp.simplecrudapp.services.UniversityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CollegeController {
    @Autowired
    UniversityManagementService service;

    @GetMapping("/college/{id}")
    public College getCollegeById(@PathVariable Integer id){
        return service.getCollegeById(id);
    }
}
