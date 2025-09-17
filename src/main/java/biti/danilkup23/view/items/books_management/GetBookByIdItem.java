package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputUtil;

import java.util.Scanner;

public class GetBookByIdItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetBookByIdItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputUtil.getValidatedInteger("Please enter a id of book", "Book id", scanner);
        libraryController.getBookController().getBookById(id);
    }

    @Override
    public String getDescription() {
        return "Print book's information by id";
    }
}
