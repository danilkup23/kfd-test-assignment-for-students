package biti.danilkup23.dao;

public class LibraryDAO {
    private final BookDAO bookDAO = new BookDAO();
    private final UserDAO userDAO = new UserDAO();
    private final EntryDAO entryDAO = new EntryDAO();

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public EntryDAO getEntryDAO() {
        return entryDAO;
    }
}
