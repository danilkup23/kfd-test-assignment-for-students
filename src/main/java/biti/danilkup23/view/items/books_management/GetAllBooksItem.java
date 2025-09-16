package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;


public class GetAllBooksItem implements MenuItem {
    private LibraryController libraryController;

    public GetAllBooksItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        libraryController.getBookController().getAllBooks();
    }

    @Override
    public String getDescription() {
        return "Print all books";
    }
}
