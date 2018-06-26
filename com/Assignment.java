public class Assignment {
    private String name;
    private boolean isDone = false;
    private int grade;

    public Assignment(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doAssignment(){
        isDone = true;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isDone() {
        return isDone;
    }

    public String toString(){
        String mark = isDone? "x" : " ";
        return "[" + mark + "] " + name + " Grade: " + grade;
    }

}

