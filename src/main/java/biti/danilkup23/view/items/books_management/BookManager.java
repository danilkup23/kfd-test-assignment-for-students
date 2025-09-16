package biti.danilkup23.view.items.books_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.AbstractMenuManager;
import biti.danilkup23.view.items.ExitMenuItem;

public class BookManager extends AbstractMenuManager {
    private LibraryController libraryController;

    public BookManager(LibraryController libraryController) {
        this.libraryController = libraryController;

        menuItems.put(1, new GetAllBooksItem(libraryController));
        menuItems.put(2, new GetBookById(libraryController));
        menuItems.put(3, new AddBookItem(libraryController));
        menuItems.put(4, new RemoveBookById(libraryController));
        menuItems.put(5, new GetBookByIsbn(libraryController));

        menuItems.put(0, new ExitMenuItem(this));
    }

    @Override
    public String getDescription() {
        return "The book management";
    }
}
