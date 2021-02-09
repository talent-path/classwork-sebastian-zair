package com.tp.simplecrudapp.daos;

import com.tp.simplecrudapp.models.College;

public interface CollegeDao {
    College getById(Integer collegeId);
}
