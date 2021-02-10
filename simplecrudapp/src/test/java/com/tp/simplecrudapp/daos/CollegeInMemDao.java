package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.College;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("serviceTest")
public class CollegeInMemDao implements CollegeDao {
    @Override
    public College getById(Integer collegeId) {
        throw new UnsupportedOperationException();
    }
}
