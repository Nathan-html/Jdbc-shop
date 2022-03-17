package com.nathan.jdbc;

import com.nathan.jdbc.factories.UserDaoFactory;
import com.nathan.jdbc.models.User;
import com.nathan.jdbc.services.MenuType;
import com.nathan.jdbc.utils.ConsoleManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        selectAction();
    }

    private static void selectAction() throws SQLException {

        Boolean exit = false;
        UserDaoFactory userDAO = new UserDaoFactory();

        do {
            printMenu();
            ConsoleManager.getInstance().printToConsole(" > ", false);
            String action = ConsoleManager.getInstance().readUserInput();
            switch (action) {
                case "0" :
                    exit = true;
                    break;
                case "1" :
                    userDAO.createUser();
                    break;
                case "2" :
                    userDAO.requestId();
                    break;
                case "3" :
                    userDAO.showAll();
            }
        } while (exit != true);
    }

    private static void printMenu() {
        for (MenuType item : MenuType.values()) {
            ConsoleManager.getInstance().printToConsole(item.toString(), true);
        }
    }
}
