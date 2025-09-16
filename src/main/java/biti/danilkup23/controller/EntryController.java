package biti.danilkup23.controller;

import biti.danilkup23.dao.BookDAO;
import biti.danilkup23.dao.EntryDAO;
import biti.danilkup23.dao.UserDAO;
import biti.danilkup23.model.Entry;
import biti.danilkup23.model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EntryController {
    private final UserDAO userDAO = new UserDAO();
    private final BookDAO bookDAO = new BookDAO();
    private final EntryDAO entryDAO = new EntryDAO();

    private static final String ERROR_MESSAGE = "Database throw exception. Try again.";
    private final String HEADER_ENTRIES = "Entry id | Book id | User id | Borrow date | Return date";

    public void getAll() {
        try {
            List<Entry> entries = entryDAO.getAll();
            System.out.println(HEADER_ENTRIES);
            for (Entry entry : entries) {
                formatedPrint(entry);
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getEntryById(int id) {
        try {
            var entry = entryDAO.get(id);
            System.out.println(HEADER_ENTRIES);
            formatedPrint(entry);
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void addEntry(int bookId, int userId, LocalDate borrowDate, LocalDate returnDate) {
        try {
            entryDAO.add(new Entry(0, bookId, userId, borrowDate, returnDate));
            System.out.println("Entry was added successfully");
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private void formatedPrint(Entry entry) {
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getId());
        sb.append(" | ");
        sb.append(entry.getBookId());
        sb.append(" | ");
        sb.append(entry.getUserId());
        sb.append(" | ");
        sb.append(entry.getBorrowDate());
        sb.append(" | ");
        sb.append(entry.getReturnDate());
        System.out.println(sb);
    }
}
