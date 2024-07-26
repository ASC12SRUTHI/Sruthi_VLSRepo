package com.vls.service;

import com.vls.model.Course;
import com.vls.repository.CourseRepository;
import com.vls.repository.CourseRepositoryCollectionImpl;
import com.vls.repository.CourseRepositoryDatabaseImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService{
//        CourseRepository courseRepository=new CourseRepositoryCollectionImpl();
    static CourseRepository courseRepository=new CourseRepositoryDatabaseImpl();
    public void addCourse(Course course){
        courseRepository.addCourse(course);
//        courseRepository.addCourse(course);
    }
    public List<Course> displayCourse(){
        return courseRepository.displayCourse();
    }
    public boolean searchCourse(int courseId){
        return courseRepository.searchCourse(courseId);
    }
    public void updateCourse(int courseId){
        courseRepository.updateCourse(courseId);
    }
    public void deleteCourse(int courseId){
        courseRepository.deleteCourse(courseId);
    }
}
