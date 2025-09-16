package biti.danilkup23.controller;

import biti.danilkup23.dao.LibraryDAO;

public class LibraryController {
    private final BookController bookController = new BookController();
    private final EntryController entryController = new EntryController();
    private final UserController userController = new UserController();

    public BookController getBookController() {
        return bookController;
    }

    public EntryController getEntryController() {
        return entryController;
    }

    public UserController userController() {
        return userController;
    }
}
