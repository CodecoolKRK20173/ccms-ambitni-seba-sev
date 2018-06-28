package com.csvhandlers;

import com.models.User;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class UserArchivist {
    private static String usersHeader = "class,name,login,password,contact,classroom";

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

    public static ArrayList<String> getAssignmentNames(String filename){
        ArrayList<String> names = new ArrayList<>();
        for(String[] line : importUsersFromFile(filename)){
            names.add(line[0]);
        }
        return names;
    }



    public static void exportUsersToFile(String filename, List<User> users){
        List<String> list = new ArrayList<>();
        for(User user : users){
            list.add(user.toCSV());
        }

        exportListToCSV(filename, list, usersHeader);
    }

    public static void exportListToCSV(String filename, List<String> list, String header){
        FileWriter fw;
        try{
            fw = new FileWriter(filename, false);
            if(!header.isEmpty()) {
                fw.write(header + "\n");
            }
            for (String line : list) {
                fw.write(line + "\n");
            }
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}