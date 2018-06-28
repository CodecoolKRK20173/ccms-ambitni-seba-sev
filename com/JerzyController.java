import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class JerzyController{

    List<User> mentors = Mentor.getMentors();
    ArrayList<Student> students = Student.getStudents();
    View view = new View();
    String header = "Jerzy";
    Scanner input = new Scanner(System.in);;

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
                        //show mentors
                        view.clearTerminalScreen();
                        printMentors();
                        break;
                    case 2:
                        //show students
                        view.clearTerminalScreen();
                        printStudents();
                        break;
                    case 3:
                        //add mentor
                        view.clearTerminalScreen();
                        addMentor();
                        break;
                    case 4:
                        //remove mentor
                        view.clearTerminalScreen();
                        String contact = getMentorContact();
                        User chosenMentor = chooseMentor(contact, mentors);
                        removeMentor(chosenMentor, mentors);
                        break;
                    case 5:
                        //edit mentor data
                        view.clearTerminalScreen();
                        getMentorContact();
                        //chosenMentor = null;
                        editMentorData(mentors);
                        break;
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
        view.printJerzyMenu();
    }

    private void printMentors(){
        for(User mentor : mentors)
            view.print(mentor.toString());
        
    }

    private void addMentor(){
        Scanner input = new Scanner(System.in);
        System.out.print("Mentor's full name: ");
        String name = input.nextLine();
        System.out.print("\nMentor's login: ");
        String login = input.nextLine();
        System.out.print("\nPassword: ");
        String password = input.nextLine();
        System.out.print("\nMentor's conact e-mail: ");
        String contact = input.nextLine();
        User mentor = new Mentor(login, password, name, contact);
        
    }


    private User chooseMentor(String contact, List<User> mentors){
        User chosenMentor = null;
        for(User mentor : mentors){
            if(mentor.getContact().equals(contact)){
                chosenMentor = mentor;
            }
        }
        return chosenMentor;
    }

    private String getMentorContact(){
        String contact = input.nextLine();
        return contact;
    }


    private void removeMentor(User chosenMentor, List<User> mentors){
        printMentors();
        Scanner input = new Scanner(System.in);
        System.out.println("Provide contact e-mail of mentor to remove");
        String contact = getMentorContact();
        if(chosenMentor == null){
            chosenMentor = chooseMentor(contact, mentors);
            mentors.remove(chosenMentor);
            System.out.println("\nMentor removed!");
        }else System.out.println("\nMentor not found!");
        
    }

    private void editMentorData(List<User> mentors){
        printMentors();
        Scanner input = new Scanner(System.in);
        System.out.println("\nProvide contact email of mentor you wish to edit:");
        String contact = getMentorContact();
        User chosenMentor = chooseMentor(contact, mentors);
        if(chosenMentor != null){
            System.out.println("Provide new login for " + contact);
            String login = input.nextLine();
            chosenMentor.setLogin(login);
            System.out.println("Provide new password for " + contact);
            String password = input.nextLine();
            chosenMentor.setPassword(password);
            System.out.println("Provide new name for " + contact);
            String name = input.nextLine();
            chosenMentor.setName(name);
            System.out.println("\nUser " + contact + " edited!");
        }else System.out.println("\nMentor not found!");
        
    }

    private void printStudents(){
        for(User student : students){
            view.print(student.toString());
        }
    }

}