package com.vls.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    @BeforeEach
    void setUp(){
        course=new Course(1,"Java","James Gosling" , Duration.ofHours(10),true);
    }
    @Test
    void testCourseCreation(){
        assertNotNull(course);
    }
    @Test
    void testCourseId(){
        assertEquals(1,course.getCourseId());
    }
    @Test
    void testCourseName(){
        assertEquals("Java",course.getCourseName());
    }
    @Test
    void testAuthorName(){
        assertEquals("James Gosling",course.getAuthorName());
    }
    @Test
    void testCourseDurationInHours(){
        assertEquals(Duration.ofHours(10),course.getCourseDurationInHours());
    }
    @Test
    void testCourseAvailability(){
        assertTrue(course.getCourseAvailability());
    }

}

