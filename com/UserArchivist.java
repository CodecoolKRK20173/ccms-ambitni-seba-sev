import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class UserArchivist {

    public static ArrayList<String[]> importUsersFromFile(String filename){

        ArrayList<String[]> fileLines = new ArrayList<String[]>();
        File data = new File(filename);

        try{
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] userInfo = line.split(",");
                fileLines.add(userInfo);
            }
            scanner.close();
        } 
        catch (IOException e){
            e.printStackTrace();
        }
        return fileLines;
    }
    

    public void exportUsersToFile(String filename, List<User> users){
        FileWriter fw = null;
        String header = "class,name,login,password,contact,classroom";

        try{
            fw = new FileWriter(filename, false);
        }catch(IOException e){
            e.printStackTrace();
        }

        BufferedWriter bw = new BufferedWriter(fw);

        try{
            fw.write(header);
            for(User user: users){
                fw.write(user.toCSV());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}