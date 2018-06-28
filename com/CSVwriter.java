import java.util.ArrayList;
import java.util.List;

public class CSVwriter {
    private List<User> users;

    public CSVwriter(List<User> users){
        this.users = users;
    }

    public void saveAlltoCSV(){
        saveUsers();
        saveAssignments();
        saveDoneAssignments();
        savePresence();
    }

    private void saveUsers(){
        UserArchivist.exportUsersToFile("userData.csv", users);
    }

    private void saveAssignments(){
        UserArchivist.exportListToCSV("assignment.csv", Assignment.getAssignmentsToList(), "name");
    }

    private void savePresence(){
        UserArchivist.exportListToCSV("presence.csv", Student.presenceCSV(), "contact");
    }

    private void saveDoneAssignments(){
        List<String> doneAss = new ArrayList<>();

        for(Student s : Student.getStudents()){
              doneAss.addAll(s.assignmetCSV());
        }

        UserArchivist.exportListToCSV("doneAssignments.csv", doneAss, "name,grade,contact");
    }


}
