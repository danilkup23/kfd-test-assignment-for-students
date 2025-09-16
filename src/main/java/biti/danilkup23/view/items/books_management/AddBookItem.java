package biti.danilkup23.view.items.books_management;

import java.util.Scanner;

import biti.danilkup23.controller.BookController;
import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

public class AddBookItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public AddBookItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        String title = InputValidatorUtil.getValidatedString("Please enter a title", "Title", scanner);
        String authorName = InputValidatorUtil.getValidatedString("Please enter a author's name", "Author's name", scanner);
        int writingYear = InputValidatorUtil.getValidatedInteger("Please enter book writing year", "Writing year", scanner);
        String isbn = InputValidatorUtil.getValidatedString("Please enter ISBN", "ISBN", scanner);
        boolean isAvailable = InputValidatorUtil.getValidatedBoolean("Please enter available status (Yes/No)", "Available status", scanner);
        libraryController.getBookController().addBook(title, authorName, writingYear, isbn, isAvailable);
    }

    @Override
    public String getDescription() {
        return "Add book to the library";
    }
}
