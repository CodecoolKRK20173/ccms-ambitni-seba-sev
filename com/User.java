
public abstract class User {
    String login;
    String password;
    String name;
    String contact;
    public User(String login, String password, String name, String contact){
        this.login = login;
        this.password = password;
        this.name = name;
        this.contact = contact;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }


    public String getContact(){
        return contact;
    }

    public String toString(){
        return "login: " + getLogin() + " pass: " + getPassword() + " name: " + getName() + " contact: " + getContact();
    }
}