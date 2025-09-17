package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class GetUserByIdItem implements MenuItem {
    private LibraryController libraryController;
    private static final Scanner scanner = new Scanner(System.in);

    public GetUserByIdItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputUtil.getValidatedInteger("Please enter a user id", "User id", scanner);
        libraryController.getUserController().getUserById(id);
    }

    @Override
    public String getDescription() {
        return "Print user's information by id";
    }
}
