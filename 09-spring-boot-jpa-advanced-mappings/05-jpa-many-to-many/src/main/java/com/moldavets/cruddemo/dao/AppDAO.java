package com.moldavets.cruddemo.dao;

import com.moldavets.cruddemo.entity.Course;
import com.moldavets.cruddemo.entity.Instructor;
import com.moldavets.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    void update(Instructor instructor);
    void update(Course course);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsById(int id);


}
