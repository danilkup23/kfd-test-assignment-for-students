package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

import java.util.Scanner;

public class GetBookById implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetBookById(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputValidatorUtil.getValidatedInteger("Please enter a id of book", "Book id", scanner);
        libraryController.getBookController().getBookById(id);
    }

    @Override
    public String getDescription() {
        return "Print information of book by id";
    }
}
