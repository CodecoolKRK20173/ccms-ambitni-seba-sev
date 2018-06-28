import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentController{

    private List<Assignment> assignments = Assignment.getAssignments();
    private String header = "Student";
    private Scanner input = new Scanner(System.in);
    private Student user;

    public StudentController(Student user){
        this.user = user;
    }

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
                        View.clearTerminalScreen();
                        View.printList(Assignment.getAssignmentsToList());
                        user.addAssignment(chooseAss());
                        break;
                    case 2:
                        View.clearTerminalScreen();
                        printAss(user.getAssigments());
                        break;
                    case 0:
                        menuRunning=false;
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

    private Assignment chooseAss(){
        int choose = promptForInt() - 1;
        return Assignment.getAssignment(choose);
    }

    private void printMenu(String header){
        View.printStudentMenu(header);
    }

    private void printAss(List<Assignment> assList){
        int i = 1;
        for(Assignment a : assList) {
            View.print(i + a.toString());
            i++;
        }
    }
}