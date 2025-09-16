package biti.danilkup23.controller;

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

    public UserController getUserController() {
        return userController;
    }
}
