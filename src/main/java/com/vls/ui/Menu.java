package com.vls.ui;

import com.vls.model.Course;
import com.vls.service.CourseService;
import com.vls.service.CourseServiceImpl;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CourseService courseServiceImpl=new CourseServiceImpl();
    Scanner sc=new Scanner(System.in);
    public void displayMenu(){
        System.out.println("1. Add course.sql");
        System.out.println("2. Display course.sql");
        System.out.println("3. search course.sql");
        System.out.println("4. update course.sql");
        System.out.println("5. delete course.sql");
        System.out.println("other values will exit");
    }
    public int getChoice(){
        return sc.nextInt();
    }
    public Course getCourse(){
        System.out.println("Enter Course ID");
        int coursetId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Course Name");
        String courseName=sc.nextLine();
        System.out.println("Enter Author Name");
        String authorName=sc.nextLine();
        System.out.println("Enter Course Duration In Hours");
        Duration courseDurationInHours=Duration.ofHours(sc.nextInt());
        System.out.println("Enter Course is Available or not");
        boolean courseAvailability=sc.nextBoolean();
        return new Course(coursetId,courseName,authorName,courseDurationInHours,courseAvailability);
    }
    public void addCourse(Course course){
        courseServiceImpl.addCourse(course);
    }
    public void displayCourse(){
        List<Course> courseList=courseServiceImpl.displayCourse();
        for(Course course:courseList){
            System.out.println(course);
        }
    }
    public void searchCourse(){
        System.out.println("Enter Course-Id for Search");
        boolean courseFound=courseServiceImpl.searchCourse(sc.nextInt());
        if(courseFound){
            System.out.println("Course Found");
        }
        else{
            System.out.println("Course Not Found");
        }
    }
    public void updateCourse(){
        System.out.println("Enter courseId for update");
        courseServiceImpl.updateCourse(sc.nextInt());
    }

    public void deleteCourse(){
        System.out.println("Enter Course-Id To Delete");
        courseServiceImpl.deleteCourse(sc.nextInt());
    }
}

