package biti.danilkup23.controller;

import java.sql.SQLException;
import java.util.List;

import biti.danilkup23.dao.BookDAO;
import biti.danilkup23.model.Book;

public class BookController {
    private static final String ERROR_MESSAGE = "Database throw exception. Try again.";
    private static final String HEADER_BOOKS = "id | title | Author's name | Writing year | ISBN | Available status";
    private final BookDAO bookDAO = new BookDAO();

    public void addBook(String title, String authorName, int writingYear, String ISBN, boolean isAvailable) {
        try{
            Book newBook = new Book(0, title, authorName, writingYear, ISBN, isAvailable);
            bookDAO.add(newBook);
            System.out.println("Book added successfully!");
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getAllBooks() {
        try {
            List<Book> books = bookDAO.getAll();
            System.out.println(HEADER_BOOKS);
            for (Book book : books) {
                formatedPrint(book);
            }
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getBookById(int id) {
        try {
            var book = bookDAO.get(id);
            System.out.println(HEADER_BOOKS);
            formatedPrint(book);

        } catch (SQLException e) {
            System.out.println("Database throw exception. Try again.");
        }
    }

    public void removeBookById(int id) {
        try {
            bookDAO.removeById(id);
            System.out.println("Book was deleted successfully");
        } catch (SQLException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public void getBookByIsbn(String isbn) {
        try {
            Book book = bookDAO.getBookByIsbn(isbn);
            System.out.println(HEADER_BOOKS);
            formatedPrint(book);
        } catch (SQLException e) {
            System.out.println("Book was not found. Try again.");
        }

    }

    private void formatedPrint(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append(book.getId());
        sb.append(" | ");
        sb.append(book.getTitle());
        sb.append(" | ");
        sb.append(book.getAuthorName());
        sb.append(" | ");
        sb.append(book.getWritingYear());
        sb.append(" | ");
        sb.append(book.getIsbn());
        sb.append(" | ");
        sb.append(book.getIsAvailable());
        System.out.println(sb);
    }
}
