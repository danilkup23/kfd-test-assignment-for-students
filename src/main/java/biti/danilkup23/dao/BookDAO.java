package biti.danilkup23.dao;

import biti.danilkup23.dao.utils.DatabaseConnector;
import biti.danilkup23.dao.utils.SQLQueries;
import biti.danilkup23.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book>{
    private static final String ADD_BOOK_QUERY = "INSERT INTO books(book_title, book_author_name, book_writing_year, book_isbn, is_available) VALUES(?, ?, ?, ?, ?);";

    @Override
    public Book get(int id) throws SQLException {
        Book book = null;

        try (Connection connection = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_BY_ID.getQuery())) {

            preparedStatement.setString(1, "books");
            preparedStatement.setString(2, "book_id");
            preparedStatement.setInt(3, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            book = new Book(
                    resultSet.getInt("book_id"),
                    resultSet.getString("book_title"),
                    resultSet.getString("book_author_name"),
                    resultSet.getInt("book_writing_year"),
                    resultSet.getString("book_isbn"),
                    resultSet.getBoolean("is_available")
            );
        }

        return book;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL.getQuery())) {

            preparedStatement.setString(1, "books");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("book_id"),
                        resultSet.getString("book_title"),
                        resultSet.getString("book_author_name"),
                        resultSet.getInt("book_writing_year"),
                        resultSet.getString("book_isbn"),
                        resultSet.getBoolean("is_available")
                ));
            }
        }

        return books;
    }

    @Override
    public void add(Book book) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK_QUERY)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setInt(3, book.getWritingYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setBoolean(5, book.getIsAvailable());
            preparedStatement.executeUpdate();

        }
    }

    @Override
    public void removeById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.REMOVE_BY_ID.getQuery())) {

            preparedStatement.setString(1, "books");
            preparedStatement.setString(2, "book_id");
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        }
    }
}
