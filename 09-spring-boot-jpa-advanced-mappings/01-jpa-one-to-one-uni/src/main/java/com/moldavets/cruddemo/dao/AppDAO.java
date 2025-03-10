package com.moldavets.cruddemo.dao;

import com.moldavets.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
