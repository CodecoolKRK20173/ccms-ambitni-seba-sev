import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MentorController{
    
    List<Assignment> assignments = Assignment.getAssignments();
    ArrayList<Student> students = Student.getStudents();
    String header = "Mentor";
    Scanner input = new Scanner(System.in);;

    public void launchController(){

        try{
            boolean menuRunning = true;
            int choice;

            while(menuRunning){
                System.out.println("\n");
                printMenu();
                choice = promptForInt();
                String contact = getStudentContact();
                Student chosenStudent = chooseStudent(contact, students);

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
                        addStudentToClassroom(chosenStudent);
                        break;

                    case 3:
                        //remove student from classroom
                        View.clearTerminalScreen();
                        printStudents();
                        removeStudentFromClassroom(chosenStudent);
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

                    case 7:
                    //check attendance
                        checkPresenceOfStudents();

                    case 0:
                        System.exit(0);
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
        String assignmentName = input.nextLine();
        Assignment assign = new Assignment(assignmentName);
        Assignment.addAssignment(assign);

    }

    private String chooseAssignmentName(){
        String assignName = input.nextLine();
        return assignName;
    }

    private Assignment getAssignment(String assignName, List<Assignment> assignments){
        Assignment chosenAssignment = null;
        for(Assignment assign : assignments){
            if(assign.getName().equals(assignName)){
                chosenAssignment = assign;
            }
           
        }            
        return chosenAssignment;
    }

    private void gradeAssignment(List<Assignment> assignments){
        String assignName = chooseAssignmentName();
        Assignment assign = getAssignment(assignName, assignments);
        int grade = promptForInt();
        assign.setGrade(grade);
    
    }

    //@TODO
    private void checkPresenceOfStudents(){

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