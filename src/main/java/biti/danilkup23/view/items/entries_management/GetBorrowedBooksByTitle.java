package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class GetBorrowedBooksByTitle implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetBorrowedBooksByTitle(LibraryController libraryController) {
        this.libraryController = libraryController;
    }


    @Override
    public void execute() {
        String title = InputUtil.getValidatedString("Please enter a book title", "Book title", scanner);
        libraryController.getEntryController().getBorrowedBooksByTitle(title);
    }

    @Override
    public String getDescription() {
        return "Print borrowed books by title";
    }
}
