package com.models;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private static ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private boolean presence = false;
    private String classroom = "Not assigned";

    public Student(String login, String password, String name, String contact){
        super(login, password, name, contact);
        students.add(this);

    }

    public static void removeStudent(User student){
        students.remove(student);
    }

    public static User getStudent(int index){
        return students.get(index);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public Assignment getAssignment(int index) {
        return assignments.get(index);
    }

    public ArrayList<Assignment> getAssigments() {
        return assignments;
    }

    public Boolean isPresent() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void addAssignment(Assignment a){
        this.assignments.add(a);

    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public String toCSV(){
        String csv = super.toCSV();
        csv = csv.substring(0, csv.length()-1) + this.classroom;
        return csv;

    }

    public String toString(){
        return super.toString() + " Classroom: " + classroom + " Presence: " + isPresent().toString();
    }

    public static List<String> presenceCSV(){
        List<String> presList = new ArrayList<>();
        for(Student s : students){
            if(s.isPresent()){
                presList.add(s.getContact());
            }
        }
        return  presList;
    }

    public List<String> assignmetCSV(){
        ArrayList<String> doneAss = new ArrayList<>();
        for(Assignment a : this.assignments){
            doneAss.add(a.toCSV() + "," + getContact());
        }

        return doneAss;
    }
}
