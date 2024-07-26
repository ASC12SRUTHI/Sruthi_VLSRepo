package com.vls.service;

import com.vls.model.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    List<Course> displayCourse();
    boolean searchCourse(int courseId);
    void updateCourse(int courseId);
    void deleteCourse(int courseId);
}
