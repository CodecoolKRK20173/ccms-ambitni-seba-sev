import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

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
        catch (Exception e){
            e.printStackTrace();
        }
        return fileLines;
    }

    //exportUsersToFile

}