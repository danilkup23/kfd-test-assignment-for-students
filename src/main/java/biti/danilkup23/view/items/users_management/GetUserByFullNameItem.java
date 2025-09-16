package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

import java.util.Scanner;

public class GetUserByFullNameItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetUserByFullNameItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        String firstName = InputValidatorUtil.getValidatedString("Please enter a name", "Name", scanner);
        String lastName = InputValidatorUtil.getValidatedString("Please enter a surname", "Surname", scanner);
        libraryController.getUserController().getUserByFullName(firstName, lastName);
    }

    @Override
    public String getDescription() {
        return "Print user's information by full name";
    }
}
