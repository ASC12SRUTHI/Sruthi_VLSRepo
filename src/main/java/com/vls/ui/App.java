package com.vls.ui;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean login=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","mysql");
            Statement statement=connection.createStatement();
            System.out.println("Enter username");
            String username=sc.nextLine();
            System.out.println("Enter password");
            String password= sc.nextLine();
            ResultSet resultSet=statement.executeQuery("select * from login where username=\'"+username+"\' and password=\'"+password+"\'");
            if(resultSet.next()) login=true;
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
        if(login){
            System.out.println("Login successful");
            System.out.println("Welcome Virtual Learning System");
            Menu menu=new Menu();
            menu.displayMenu();
            System.out.println("Enter choice from above display");
            int choice=menu.getChoice();
            while(choice>=1&&choice<=5){
                switch(choice){
                    case 1:
                        menu.addCourse(menu.getCourse());
                        break;
                    case 2:
                        menu.displayCourse();
                        break;
                    case 3:
                        menu.searchCourse();
                        break;
                    case 4:
                        menu.updateCourse();
                        break;
                    case 5:
                        menu.deleteCourse();
                        break;
                    default:
                        break;
                }
                menu.displayMenu();
                System.out.println("Enter choice from above display");
                choice=menu.getChoice();
            }
        }
        else{
            System.out.println("login unsuccessful");
        }
    }
}

