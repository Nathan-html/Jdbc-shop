package com.nathan.jdbc.factories;

import com.nathan.jdbc.models.User;
import com.nathan.jdbc.utils.ConsoleManager;
import com.nathan.jdbc.utils.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoFactory implements DAO<User, Integer> {

    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public void createUser() throws SQLException {
        ConsoleManager.getInstance().printToConsole("Type the first name", true);
        ConsoleManager.getInstance().printToConsole(" > ", false);
        firstName = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the last name", true);
        ConsoleManager.getInstance().printToConsole(" > ", false);
        lastName = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the login", true);
        ConsoleManager.getInstance().printToConsole(" > ", false);
        login = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the password", true);
        ConsoleManager.getInstance().printToConsole(" > ", false);
        password = ConsoleManager.getInstance().readUserInput();
        if(password.isEmpty()) {
            password = "1234";
        }

        User user = new User(this.firstName, this.lastName, this.login, this.password);
        save(user);
    }

    public void requestId() throws SQLException {
        ConsoleManager.getInstance().printToConsole("Type the id of the user you want", true);
        ConsoleManager.getInstance().printToConsole(" > ", false);
        Integer id = ConsoleManager.getInstance().readUserInputInteger();

        ConsoleManager.getInstance().printToConsole(getById(id).toStringSingle(), true);
    }

    public void showAll() throws SQLException {
        for (User item : getAll()) {
            ConsoleManager.getInstance().printToConsole(item.toString(), true);
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        String query = "SELECT * FROM user";
        Statement statement = DBconnect.getInstance().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<>();

        while(resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            User user = new User(firstName, lastName, login, password);
            users.add(user);
        }
        statement.close();
        return users;
    }

    @Override
    public User getById(Integer integer) throws SQLException {
        String query = "SELECT * FROM user where id = " + integer + ";";
        Statement statement = DBconnect.getInstance().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        User user = null;

        if(resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            user = new User(firstName, lastName, login, password);
        }
        statement.close();
        return user;
    }

    @Override
    public void save(User user) throws SQLException {

        String query = "INSERT INTO user (first_name, last_name, login, password)" +
                "VALUES('" +
                    user.getFirstName()+"', '" +
                    user.getLastName() +"', '" +
                    user.getLogin() + "', '"+
                    user.getPassword() +"');";
        Statement statement = DBconnect.getInstance().createStatement();
        statement.execute(query);
        statement.close();

//        String query = "INSERT INTO user (first_name, last_name, login, password) VALUES(? ? ? ?);";
//        PreparedStatement statement = DBconnect.getInstance().prepareStatement(query);
//        statement.setString(1, user.getFirstName());
//        statement.setString(2, user.getLastName());
//        statement.setString(3, user.getLogin());
//        statement.setString(4, user.getPassword());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
