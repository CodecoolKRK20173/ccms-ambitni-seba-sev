package com.models;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String name;
    private int grade;

    private static ArrayList<Assignment> assignments = new ArrayList<>();

    public Assignment(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void addAssignment(Assignment a){
        assignments.add(a);
    }

    public static List<Assignment> getAssignments(){ return assignments; }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public static ArrayList<String> getAssignmentsToList() {
        ArrayList<String> names = new ArrayList<>();
        for(Assignment a : assignments){
            names.add(a.getName());
        }
        return names;
    }

    public static Assignment getAssignment(int index){
        return assignments.get(index);
    }

    public String toString(){
        return name + ", Grade: " + grade;
    }

    public String toCSV(){
        return name + "," + grade;
    }
}

