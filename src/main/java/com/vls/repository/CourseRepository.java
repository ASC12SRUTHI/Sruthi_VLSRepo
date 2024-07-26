package com.vls.repository;

import com.vls.model.Course;

import java.util.List;

public interface CourseRepository {
    void addCourse(Course course);
    List<Course> displayCourse();
    boolean searchCourse(int courseId);
    void updateCourse(int courseId);
    void deleteCourse(int courseId);
}
