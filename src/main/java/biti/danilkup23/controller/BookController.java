package biti.danilkup23.controller;

import java.sql.SQLException;

import biti.danilkup23.dao.BookDAO;
import biti.danilkup23.model.Book;

public class BookController {
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
            System.out.println("Database return error. Try again.");
        }
    }


}
