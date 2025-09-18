package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class GetBorrowedBooksByUserIdItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetBorrowedBooksByUserIdItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputUtil.getValidatedInteger("Please enter user id", "User id", scanner);
        libraryController.getEntryController().getBorrowedBooksByUserId(id);
    }

    @Override
    public String getDescription() {
        return "Print borrowed books by user id";
    }
}
