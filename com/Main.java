package com;

import com.controller.LoginController;
import com.csvhandlers.CSVwriter;
import com.csvhandlers.UserCreator;

public class Main {

    public static void main(String[] args){

        UserCreator u = new UserCreator();

        LoginController lc = new LoginController(u.getUsersList());
        lc.loginProcess();
        CSVwriter writer = new CSVwriter(u.getUsersList());
        writer.saveAlltoCSV();
    }
}
