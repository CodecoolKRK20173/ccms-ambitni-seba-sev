import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class EmployeeController{
    
    ArrayList<Student> students = Student.getStudents();
    View view = new View();
    String header = "Employee";
    Scanner input = new Scanner(System.in);;

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
                        view.clearTerminalScreen();
                        printStudents();
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

    

    private void printMenu(String header){
        view.printEmployeeMenu(header);
    }
    
    private void printStudents(){
        for(Student student : students)
            view.print(student.toString());
    }
}