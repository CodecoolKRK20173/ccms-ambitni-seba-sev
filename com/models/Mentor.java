package com.models;

import com.models.User;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends User{
    public static ArrayList<User> mentors = new ArrayList<User>();
    private static ArrayList<String> classrooms = new ArrayList<>();

    public Mentor(String login, String password, String name, String contact){
        super(login, password, name, contact);
        mentors.add(this);
    }

    public void removeMentor(User mentor){
        mentors.remove(mentor);
    }

    public User getMentor(int index){
        return mentors.remove(index);
    }

    public static List<User> getMentors(){
        return mentors;
    }

    public static ArrayList<String> getClassrooms() {
        return classrooms;
    }

    public static String getClassroom(int index){
        return classrooms.get(index);
    }

}


