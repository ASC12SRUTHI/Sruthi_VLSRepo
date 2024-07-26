package com.vls.repository;

import com.vls.exception.DuplicateCourseException;
import com.vls.model.Course;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRepositoryDatabaseImpl implements CourseRepository{
    Scanner sc=new Scanner(System.in);
    public void addCourse(Course course){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into course values(?,?,?,?,?);");
            preparedStatement.setInt(1,course.getCourseId());
            preparedStatement.setString(2,course.getCourseName());
            preparedStatement.setString(3,course.getAuthorName());
            long duration =course.getCourseDurationInHours().toHours();
            preparedStatement.setLong(4,duration);
            preparedStatement.setBoolean(5,course.getCourseAvailability());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            try{
                if(sqlException.getErrorCode()==1062){
                    throw new DuplicateCourseException("PrimaryKey already exists");
                }
            }
            catch (DuplicateCourseException duplicateCourseException){
                System.out.println(duplicateCourseException.getMessage());
            }
            System.out.println(sqlException.getMessage());
        }
    }
    public List<Course> displayCourse(){
        List<Course> courseList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from course");
            while(resultSet.next()){
                int courseId=resultSet.getInt(1);
                String coursename=resultSet.getString(2);
                String authorname=resultSet.getString(3);
                long duration = resultSet.getLong(4);
                Duration duration1=Duration.ofHours(duration);
                boolean availability=resultSet.getBoolean(5);
                Course course=new Course(courseId,coursename,authorname,duration1,availability);
                courseList.add(course);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return courseList;
    }
    public boolean searchCourse(int courseId){
        boolean courseFound=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from course where courseId=\'"+courseId+"\'");
            while(resultSet.next()){
                courseFound=true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return courseFound;
    }
    public void updateCourse(int courseId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            String query="update course set ";
            System.out.println("1. update courseName");
            System.out.println("2. update authorName");
            System.out.println("3. update courseDurationInHours");
            System.out.println("4. update courseAvailability");
            System.out.println("other values will exit");
            System.out.println("Enter choice to update");
            int choice=sc.nextInt();
            while(choice>=1&&choice<=4){
                switch(choice){
                    case 1:
                        sc.nextLine();
                        query+="courseName=";
                        System.out.println("Enter courseName to update");
                        query+=("\'"+sc.nextLine()+"\'");
                        break;
                    case 2:
                        sc.nextLine();
                        query+="authorName=";
                        System.out.println("Enter authorName to update");
                        query+=sc.nextLine();
                        break;
                    case 3:
                        query+="courseDurationInHours=";
                        System.out.println("Enter courseDurationInHours to update");
                        query+=sc.nextInt();
                        break;
                    case 4:
                        query+="courseAvailability=";
                        System.out.println("Enter courseAvailablility to update");
                        query+=sc.nextBoolean();
                        break;
                    default:
                        break;
                }
                System.out.println("Enter choice to update");
                choice= sc.nextInt();
                if(choice>=1&&choice<=4) query+=" , ";
            }
            query+=(" where courseId="+courseId+";");
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void deleteCourse(int courseId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            statement.executeUpdate("delete from course where courseId=\'"+courseId+"\'");
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
}



