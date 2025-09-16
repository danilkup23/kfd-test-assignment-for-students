package biti.danilkup23.controller;

import biti.danilkup23.dao.UserDAO;
import biti.danilkup23.model.*;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private static final String ERROR_MESSAGE = "Database throw exception. Try again.";
    private static final String HEADER_USERS = "id | type | First name | Last name | email";
    private UserDAO userDAO = new UserDAO();

    public void addUser(String type, String firstName, String lastName, String email) {
        try {
            switch (type) {
                case "STUDENT":
                    userDAO.add(new Student(0, type, firstName, lastName, email));
                    System.out.println("Student was added successfully");
                    break;
                case "FACULTY":
                    userDAO.add(new Faculty(0, type, firstName, lastName, email));
                    System.out.println("Faculty was added successfully");
                    break;
                case "GUEST":
                    userDAO.add(new Guest(0, type, firstName, lastName, email));
                    System.out.println("Guest was added successfully");
                    break;
                default:
                    System.out.println("User's type error. Try again.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getAllUsers() {
        try {
            List<User> users = userDAO.getAll();
            System.out.println(HEADER_USERS);
            for (User user : users) {
                formatedPrint(user);
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getUserById(int id) {
        try {
            var user = userDAO.get(id);
            System.out.println(HEADER_USERS);
            formatedPrint(user);
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void removerUserById(int id) {
        try {
            userDAO.removeById(id);
            System.out.println("User was deleted successfully");
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getUserByFullName(String firstName, String lastName) {
        try {
            var user = userDAO.getUserByFullName(firstName, lastName);
            System.out.println(HEADER_USERS);
            formatedPrint(user);
        } catch (SQLException e) {
            System.out.println("The user with this full name doesn't exist");
        }
    }

    private void formatedPrint(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getId());
        sb.append(" | ");
        sb.append(user.getType());
        sb.append(" | ");
        sb.append(user.getFirstName());
        sb.append(" | ");
        sb.append(user.getLastName());
        sb.append(" | ");
        sb.append(user.getEmail());
        System.out.println(sb);
    }

}
