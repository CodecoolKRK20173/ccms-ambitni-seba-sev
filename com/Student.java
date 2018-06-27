
import java.util.ArrayList;

public class Student extends User{
    private static ArrayList<User> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private boolean presence = false;
    private String classroom = "Not assigned";

    public Student(String login, String password, String name, String contact){
        super(login, password, name, contact);
        students.add(this);

    }

    public static void removeStudent(User student){
        students.remove(student);
    }

    public static User getStudent(int index){
        return students.get(index);
    }

    public static ArrayList<User> getStudents() {
        return students;
    }

    public Assignment getAssignment(int index) {
        return assignments.get(index);
    }

    public ArrayList<Assignment> getAssigments() {
        return assignments;
    }

    public Boolean isPresent() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void addAssignment(Assignment a){
        this.assignments.add(a);

    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public String toCSV(){
        String csv = super.toCSV();
        csv = csv.substring(0, csv.length()-1) + this.classroom;
        return csv;

    }

    public String toString(){
        return super.toString() + " Presence: " + isPresent().toString();
    }

    public String presenceCSV(){
        if(isPresent()) {
            return getContact();
        }else{
            return null;
        }
    }


}
