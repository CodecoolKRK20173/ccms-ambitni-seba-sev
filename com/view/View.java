package com.view;

import java.util.List;

public class View {


    private static String[] employeeList = {"Show Students"};
    private static String[] studentList = {"Submit Assignment", "Show grades"};
    private static String[] jerzyList = {"Show mentors", "Show Students", "Add Mentor", "Remove Mentor", "Edit Mentor"};
    private static String[] mentorList = {"Show Students", "Add Student to classroom", "Remove Student from classroom", "Edit Student", "Add assignment"
            ,"Grade Assignment", "Check Attendance"};



    public static void clearTerminalScreen() {
        System.out.print("\033[H\033[2J");
        }

    public static void printList(List<String> list){
        int i = 1;
        for(String s : list){
            System.out.println(i + "." + s);
            i++;
        }
    }


    public static void printMenu(String name, String[] menuList){

        System.out.println("Hello " + name);
        System.out.println("What would you like to do:");
        int i = 1;

        for(String line : menuList){
            System.out.println("    ("+ i +") " + line);
            i++;
        }
        System.out.println("    (0) Exit");


    }

    public static void print(Object o){
        System.out.println(o);
    }

    public static void printEmployeeMenu(String name){
        printMenu(name, employeeList);
    }

    public static void printStudentMenu(String name){
        printMenu(name, studentList);
    }

    public static void printMentorMenu(String name){
        printMenu(name, mentorList);
    }


    public static void printJerzyMenu(){
        printMenu("Jerzy", jerzyList);
    }

}
