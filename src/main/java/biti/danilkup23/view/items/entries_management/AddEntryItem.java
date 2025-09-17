package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.dao.utils.DAOUtil;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;
import biti.danilkup23.view.utils.PrintUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class AddEntryItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public AddEntryItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }


    @Override
    public void execute() {
        int bookId = InputUtil.getValidatedInteger("Please enter a book id", "Book id", scanner);
        int userId = InputUtil.getValidatedInteger("Please enter a user id", "User id", scanner);
        LocalDate borrowDate = InputUtil.getValidatedLocalDate("Please enter a borrow date", "Borrow date", scanner);
        LocalDate returnDate = InputUtil.getValidatedLocalDate("Please enter a return date", "Return date", scanner);
        libraryController.getEntryController().addEntry(bookId, userId, borrowDate, returnDate);
    }

    @Override
    public String getDescription() {
        return "Add a new entry";
    }
}
