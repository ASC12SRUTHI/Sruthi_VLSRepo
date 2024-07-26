package com.vls.model;

import java.time.Duration;

public class Course {
    private int courseId;
    private String courseName;
    private String authorName;
    private Duration courseDurationInHours;
    private boolean courseAvailability;

    public Course(int courseId, String courseName, String authorName, Duration courseDurationInHours, boolean courseAvailability) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.authorName = authorName;
        this.courseDurationInHours = courseDurationInHours;
        this.courseAvailability = courseAvailability;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Duration getCourseDurationInHours() {
        return courseDurationInHours;
    }

    public void setCourseDurationInHours() {
        this.courseDurationInHours = courseDurationInHours;
    }

    public boolean getCourseAvailability() {
        return courseAvailability;
    }

    public void setCourseAvailability(boolean courseAvailability) {
        this.courseAvailability = courseAvailability;
    }
    @Override
    public String toString() {
        return "CourseId="+courseId+" CourseName="+courseName+" AuthorName="+authorName+" CourseDurationInHours="+courseDurationInHours+" courseAvailability="+courseAvailability;
    }

}
