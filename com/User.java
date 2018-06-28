
public abstract class User {
    private String login;
    private String password;
    private String name;
    private String contact;

    public User(String login, String password, String name, String contact) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.contact = contact;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getContact() {
        return contact;
    }

    public String toString() {
        return "login: " + getLogin() + " pass: " + getPassword() + " name: " + getName() + " contact: " + getContact();
    }

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + name + "," + login + "," + password + "," + contact + ", ";
    }

    public void setClassroom(String classroom) {
    }

}