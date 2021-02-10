package com.tp.simplecrudapp.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("serviceTest")
public class UniversityManagementServiceTests {

    @Autowired
    UniversityManagementService toTest;

    @Test
    public void fakeTest(){
        assertTrue(false);
    }

}
