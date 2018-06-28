package com.controller;

import com.models.Student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.view.View;
public class EmployeeController{
    
    ArrayList<Student> students = Student.getStudents();
    String header = "Employee";
    Scanner input = new Scanner(System.in);

    public void launchController(){

        try{
            boolean menuRunning = true;
            int choice;

            while(menuRunning){
                System.out.println("\n");
                printMenu(header);

                choice = promptForInt();
                
                    switch(choice){
                    case 1:
                        //show students
                        View.clearTerminalScreen();
                        printStudents();
                        break;
                        
                    case 0:
                        menuRunning = false;
                        break;
                    }
                }

            
        }catch(InputMismatchException e){
            System.out.println("Provide numeric value!");
        }
    }

    private int promptForInt() {
        Integer num = null;

        while(num == null){
            try {
                num = input.nextInt();
            } catch (InputMismatchException e){
                input.next();
            }
        }
        return num;
    }

    

    private void printMenu(String header){
        View.printEmployeeMenu(header);
    }
    
    private void printStudents(){
        for(Student student : students)
                View.print(student.toString());
    }
}