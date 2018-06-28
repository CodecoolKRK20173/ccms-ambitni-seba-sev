import java.util.Scanner;

import com.sun.javafx.collections.ElementObservableListDecorator;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LoginController{
    public LoginController(List<User> users){
        this.users = users;
    }

    public static Map<String, String> usersLoginsAndPasswords = new HashMap<>();
    private Scanner input = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    
    public void loginLogic(String providedLogin, String providedPassword){
        User userloggingIn = null;

        for(User user : users){
            String login = user.getLogin();
            String password = user.getPassword();
            usersLoginsAndPasswords.put(login, password);
        }

        if(isLoginCorrect(providedLogin)){
            
            if(isPasswordCorrect(providedLogin, providedPassword)){
                System.out.println("Zalogowano!");

                userloggingIn = chooseUser(providedLogin, users);
                chooseController(userloggingIn);

            }
            else System.out.println("Wrong password, try again!");
        }
        else System.out.println("Login or password is incorrect, try again!");
        input.close();
    }

    private User chooseUser(String login, List<User> users){
        User chosenUser = null;
        for(User user : users){
            if(user.getLogin().equals(login)){
                chosenUser = user;
            }
        }
        return chosenUser;
    }

    public String provideLogin(){
        System.out.print("LOGIN: ");
        String providedLogin = input.nextLine();
        return providedLogin;
    }

    private boolean isLoginCorrect(String providedLogin){
        if(usersLoginsAndPasswords.containsKey(providedLogin)) return true;
        else return false;
    }

    public String providePassword(){
        System.out.print("PASSWORD: ");
        String providedPassword = input.nextLine();
        return providedPassword;
    }

    private boolean isPasswordCorrect(String providedLogin, String providedPassword){
        if(usersLoginsAndPasswords.get(providedLogin).equals(providedPassword))
        return true;
        else return false;
    }

    private void loginProcess(){
        String login = provideLogin();
        String password = providePassword();
        loginLogic(login, password);
        
    }

    private void chooseController(User userLoggingIn){
        String role = userLoggingIn.getClass().getSimpleName();

        if(role.equals("Jerzy")){
            JerzyController jc = new JerzyController();
            jc.launchController();
        }
        else if(role.equals("Mentor")){
            System.out.println("Zalogowano mentora!");
            //MentorController mc = new MentorController();
            // mc.launchController();
        }
        else if(role.equals("Employee")){
            //EmployeeController ec = new EmployeeController();
            // ec.launchController();
        }else{
            // StudentController sc = new StudentContoller();
            // sc.launchController();
        }
    }
    //public static void main(String[] args){
    //    LoginController lc = new LoginController();
    //    lc.loginProcess();
    //}
    
}