package com.csvhandlers;

import com.models.*;

import java.util.ArrayList;
import java.util.List;

public class UserCreator {
        
    private final int ROLE_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int LOGIN_INDEX = 2;
    private final int PASSWORD_INDEX = 3;
    private final int CONTACT_INDEX = 4;
    private final int CLASSROOM_INDEX = 5;
    private ArrayList<String> presentStudents;

    List<User> users;
    UserArchivist userArchivist;
    ArrayList<String[]> fileLines;


    public UserCreator(){
        users = new ArrayList<User>();
        userArchivist = new UserArchivist();
        fileLines = UserArchivist.importUsersFromFile("userData.csv");
        getPresentList();
        createUsersList();
        createAssignments();
    }

    public void createUsersList(){
        fileLines.remove(0); // removing header

        for (String[] userInfo : fileLines){
            String role = userInfo[ROLE_INDEX];
            String userName = userInfo[NAME_INDEX];
            String login = userInfo[LOGIN_INDEX];
            String password = userInfo[PASSWORD_INDEX];
            String contact = userInfo[CONTACT_INDEX];
            String classroom = "";
            try{
                classroom = userInfo[CLASSROOM_INDEX];
            }catch(IndexOutOfBoundsException e){}
            User newUser;
            if(role.equals("Jerzy")){
                newUser = new Jerzy();}
            else if(role.equals("Mentor")){
                newUser = new Mentor(login, password, userName, contact);}
            else if(role.equals("Employee")){
                newUser = new Employee(login, password, userName, contact);}
            else {
                newUser = new Student(login, password, userName, contact);
                newUser.setClassroom(classroom);
                if(isPresent(newUser)){ ((Student) newUser).setPresence(true); }
            }

            users.add(newUser);
            }

    }

    public List<User> getUsersList(){
        return this.users;
    }

    private void getPresentList(){
        ArrayList<String[]> list = UserArchivist.importUsersFromFile("presence.csv");
        this.presentStudents = new ArrayList<>();
        for(String[] line : list){
            this.presentStudents.add(line[0]);
        }
    }

    private boolean isPresent(User student){
        return presentStudents.contains(student.getContact());
    }

    private void createAssignments(){
        ArrayList<String> names = UserArchivist.getAssignmentNames("assignment.csv");
        ArrayList<String[]> doneAssignments = UserArchivist.importUsersFromFile("doneAssignments.csv");
        ArrayList<Student> students = Student.getStudents();

        for(String name : names){

            Assignment.addAssignment(new Assignment(name));
            for (String[] line : doneAssignments) {

                if(line[0].equals(name)){
                    for (Student stud : students){

                        if(stud.getContact().equals(line[2])){
                            Assignment ass = new Assignment(name);
                            ass.setGrade(Integer.parseInt(line[1]));
                            stud.addAssignment(ass);
                            break;
                        }
                    }
                }
            }


        }


    }

}

