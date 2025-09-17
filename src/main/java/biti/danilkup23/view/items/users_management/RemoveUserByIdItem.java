package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class RemoveUserByIdItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public RemoveUserByIdItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputUtil.getValidatedInteger("Please enter a user id", "User id", scanner);
        libraryController.getUserController().removerUserById(id);
    }

    @Override
    public String getDescription() {
        return "Delete user by id";
    }
}
