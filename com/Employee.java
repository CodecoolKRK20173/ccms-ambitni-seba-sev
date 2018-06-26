import java.util.ArrayList;

public class Employee extends User{

    private static ArrayList<User> employees = new ArrayList<>();

    public Employee(String login, String password, String name, String contact){
        super(login, password, name, contact);
        employees.add(this);
    }

    public static ArrayList<User> getEmployees() {
        return employees;
    }

    public static void removeEmployee(User employee){
        employees.remove(employee);
    }
}
