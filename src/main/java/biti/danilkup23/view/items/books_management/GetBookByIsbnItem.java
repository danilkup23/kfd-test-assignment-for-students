package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class GetBookByIsbnItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetBookByIsbnItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        String isbn = InputUtil.getValidatedString("Please enter a ISBN", "ISBN", scanner);
        libraryController.getBookController().getBookByIsbn(isbn);
    }

    @Override
    public String getDescription() {
        return "Print a information of book by ISBN";
    }
}
