package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

import java.util.Scanner;

public class RemoveBookById implements MenuItem {
    private LibraryController libraryController;
    private Scanner scanner = new Scanner(System.in);

    public RemoveBookById(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputValidatorUtil.getValidatedInteger("Please enter the id to remove book", "Book id", scanner);
        libraryController.getBookController().removeBookById(id);
    }

    @Override
    public String getDescription() {
        return "Remove book by id";
    }
}
