package com.vls.repository;
import com.vls.exception.CourseNotFoundException;
import com.vls.exception.DuplicateCourseException;
import com.vls.model.Course;
import com.vls.repository.CourseRepository;
import java.time.Duration;
import java.util.*;

public class CourseRepositoryCollectionImpl implements CourseRepository {
    Scanner sc=new Scanner(System.in);
    Map<Integer, Course> courseMap=new HashMap<>();
    @Override
    public void addCourse(Course course){
        try{
            if(courseMap.containsKey(course.getCourseId())){
                throw new DuplicateCourseException("Course already exists");
            }
            courseMap.put(course.getCourseId(),course);
        }
        catch(DuplicateCourseException duplicateCourseException){
            System.out.println(duplicateCourseException.getMessage());
        }
    }
    public List<Course> displayCourse(){
        List<Course> courseList=new ArrayList<>();
        for(Map.Entry<Integer,Course> courseMapEntry:courseMap.entrySet()){
            courseList.add(courseMapEntry.getValue());
        }
        return  courseList;
    }
    public boolean searchCourse(int courseId){
        boolean courseFound=false;
        try{
            if(courseMap.containsKey(courseId)){
                courseFound=true;
            }
            throw new CourseNotFoundException("Course Does not exist");
        }
        catch(CourseNotFoundException courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
        return courseFound;
    }
    public void updateCourse(int courseId){
        try{
            if(courseMap.containsKey(courseId)){
                Course course=courseMap.get(courseId);
                System.out.println("1. update CourseName");
                System.out.println("2. update AuthorName");
                System.out.println("3. update CourseDurationInHours");
                System.out.println("4. update CourseAvailability");
                System.out.println("other values will exit");
                System.out.println("Enter choice to update");
                int choice=sc.nextInt();
                while(choice>=1&&choice<=4){
                    switch(choice){
                        case 1:
                            sc.nextLine();
                            System.out.println("Enter Course Name to update");
                            course.setCourseName(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter Author Name to update");
                            course.setAuthorName(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Enter Course Duration In Hours to update");
                            course.setCourseDurationInHours();
                            break;
                        case 4:
                            System.out.println("Enter Course Availability to update");
                            course.setCourseAvailability(sc.nextBoolean());
                            break;
                        default:
                            break;
                    }
                    System.out.println("Enter choice to update");
                    choice= sc.nextInt();
                }
                courseMap.put(courseId,course);
            }
            throw new CourseNotFoundException("Course Does not exists");
        }
        catch(CourseNotFoundException courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
    }
    public void deleteCourse(int courseId){
        try{
            if(courseMap.containsKey(courseId)){
                courseMap.remove(courseId);
            }
            throw new CourseNotFoundException("Course Does not exists");
        }
        catch(CourseNotFoundException courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
    }
}

