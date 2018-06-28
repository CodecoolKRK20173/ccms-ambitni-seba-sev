package com.controller;

import com.models.Assignment;
import com.models.Student;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.view.View;
public class MentorController{
    
    private List<Assignment> assignments = Assignment.getAssignments();
    private ArrayList<Student> students = Student.getStudents();
    private String header = "Mentor";
    private Scanner input = new Scanner(System.in);;

    public void launchController(){

        try{
            boolean menuRunning = true;
            int choice;

            while(menuRunning){
                System.out.println("\n");
                printMenu();
                choice = promptForInt();


                switch(choice){

                    case 1:
                        //show students
                        View.clearTerminalScreen();
                        printStudents();
                        break;

                    case 2:
                        //add students to classroom
                        View.clearTerminalScreen();
                        printStudents();
                        addStudentToClassroom(chooseStudent(getStudentContact(), students));
                        break;

                    case 3:
                        //remove student from classroom
                        View.clearTerminalScreen();
                        printStudents();
                        removeStudentFromClassroom(chooseStudent(getStudentContact(), students));
                        break;

                    case 4:
                        //edit student data
                        View.clearTerminalScreen();
                        printStudents();
                        getStudentContact();
                        editStudentData(students);
                        break;
                    case 5:

                        //addAssignment
                        View.clearTerminalScreen();
                        addAssignment();
                        break;

                    case 6:
                        //gradeAssignment
                        View.clearTerminalScreen();
                        gradeAssignment(assignments);
                        break;

                    case 7:
                    //check attendance
                        checkPresenceOfStudents();
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
                input.nextLine();
            } catch (InputMismatchException e){
                input.next();
            }
        }
        return num;
    }

    private void printMenu(){
        View.printMentorMenu(header);
    }

    private void printStudents(){
        for(Student student : students){
            View.print(student.toString());
        }

    }

    private void addStudentToClassroom(Student chosenStudent){
        String contact = getStudentContact();
        System.out.println("Input classroom name");
        String classroom = input.nextLine();
        chosenStudent = chooseStudent(contact, students);
        if(chosenStudent != null){
            chosenStudent.setClassroom(classroom);
        }else System.out.println("Student not found!");
    }

    private void removeStudentFromClassroom(Student chosenStudent){
        String contact = getStudentContact();
        chosenStudent = chooseStudent(contact, students);
        if(chosenStudent != null){
            chosenStudent.setClassroom(" ");}
        else System.out.println("Student not found!");
    }

    private void addAssignment(){
        View.print("Enter new assignment name:");
        Assignment assign = new Assignment(input.nextLine());
        Assignment.addAssignment(assign);
    }

    private Assignment getAssignment(int option){
        Student s = students.get(option);
        for(Assignment assign : s.getAssigments()){
            View.print(assign.toString());
        }
        View.print("Chose assignment: ");
        int choose = promptForInt();
        return s.getAssignment(choose - 1);
    }

    private void gradeAssignment(List<Assignment> assignments){
        View.clearTerminalScreen();
        printStudNames();
        View.print("Choose student:");
        int option = promptForInt();
        Assignment assign = getAssignment(option-1);
        View.print("Enter a grade for Assignment:");
        int grade = promptForInt();
        assign.setGrade(grade);
    
    }


    private void checkPresenceOfStudents(){
        boolean checked = false;

        while(!checked){
            int i = 1;
            printStudNames();
            View.print("0.End");
            View.print("Select student to change presence: ");
            int option = promptForInt();
            if(option == 0){
                checked = true;
            }else{
                Student s = students.get(option-1);
                s.setPresence(!s.isPresent());
            }
        }
    }

    private void printStudNames(){
        View.clearTerminalScreen();
        int i = 1;
        for(Student s : students){
            View.print(i +"."+ s.getName() + " presence: " + s.isPresent().toString() + " No. Assignments: "
                    + s.getAssigments().size());
            i++;
        }
    }


    private String getStudentContact(){
        System.out.println("\nEnter student's e-mail");
        String contact = input.nextLine();
        return contact;
    }

    private Student chooseStudent(String contact, List<Student> students){
        Student chosenStudent = null;
        for(Student student : students){
            if(student.getContact().equals(contact)){
                chosenStudent = student;
            }
        }
        return chosenStudent;
    }

    private void editStudentData(List<Student> students){
        Scanner input = new Scanner(System.in);
        System.out.println("\nProvide contact email of student you wish to edit:");
        String contact = getStudentContact();
        Student chosenStudent = chooseStudent(contact, students);
        if(chosenStudent != null){
            System.out.println("Provide new login for " + contact);
            String login = input.nextLine();
            chosenStudent.setLogin(login);
            System.out.println("Provide new password for " + contact);
            String password = input.nextLine();
            chosenStudent.setPassword(password);
            System.out.println("Provide new name for " + contact);
            String name = input.nextLine();
            chosenStudent.setName(name);
            System.out.println("\nStudent " + contact + " edited!");
        }else System.out.println("\nStudent not found!");
        
    }

}