package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

import java.util.Scanner;

public class AddUserItem implements MenuItem {
    private LibraryController libraryController;
    private static final Scanner scanner = new Scanner(System.in);

    public AddUserItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        String type = InputValidatorUtil.getValidatedType("Please enter a user's type (Student / Faculty / Guest)", "User's type", scanner).toUpperCase();
        String firstName = InputValidatorUtil.getValidatedString("Please enter a first name", "First name", scanner);
        String lastName = InputValidatorUtil.getValidatedString("Pleas enter a last name", "Last name", scanner);
        String email = InputValidatorUtil.getValidatedString("Please enter email", "Email", scanner);
        libraryController.getUserController().addUser(type, firstName, lastName, email);
    }

    @Override
    public String getDescription() {
        return "Add a new user";
    }
}
