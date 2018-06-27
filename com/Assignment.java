import java.util.ArrayList;

public class Assignment {
    private String name;
    private int grade;

    private static ArrayList<Assignment> assignments = new ArrayList<>();

    public Assignment(String name){
        this.name = name;
        assignments.add(this);
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public static ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public static Assignment getAssignment(int index){
        return assignments.get(index);
    }

    public String toString(){
        return name + " Grade: " + grade;
    }

    public String toCSV(){
        return name + "," + grade;
    }
}

