import java.util.ArrayList;
import java.util.List;

public class Mentor extends User{
    private static ArrayList<User> mentors = new ArrayList<User>();

    public Mentor(String login, String password, String name, String contact){
        super(login, password, name, contact);
        mentors.add(this);
    }

    public void removeMentor(User mentor){
        mentors.remove(mentor);
    }

    public User getMentor(int index){
        return mentors.remove(index);
    }

    public List<User> getMentors(){
        return mentors;
    }

    

}


