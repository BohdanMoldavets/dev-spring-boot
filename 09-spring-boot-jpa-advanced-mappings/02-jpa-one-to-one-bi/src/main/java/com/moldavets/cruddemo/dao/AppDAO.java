package com.moldavets.cruddemo.dao;

import com.moldavets.cruddemo.entity.Instructor;
import com.moldavets.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
