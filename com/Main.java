public class Main {

    public static void main(String[] args){

        UserCreator u = new UserCreator();

        LoginController lc = new LoginController(u.getUsersList());
        lc.loginProcess();
    }
}
