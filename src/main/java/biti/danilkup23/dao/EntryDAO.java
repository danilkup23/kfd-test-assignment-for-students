package biti.danilkup23.dao;

import biti.danilkup23.dao.utils.DAOUtil;
import biti.danilkup23.dao.utils.DatabaseConnector;
import biti.danilkup23.dao.utils.SQLQueries;
import biti.danilkup23.model.Entry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryDAO implements DAO<Entry> {
    private static final String ADD_ENTRY = "INSERT INTO entries(book_id, user_id, borrow_date, return_date) VALUES(?, ?, ?, ?)";
    // private static final String GET_BORROW_BOOKS = "SELECT book_title, book_author_name, "

    @Override
    public Entry get(int id) throws SQLException {
        Entry entry = null;

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_BY_ID.getQuery())) {

            preparedStatement.setString(1, "entries");
            preparedStatement.setString(2, "entry_id");
            preparedStatement.setInt(3, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            entry = new Entry(
                resultSet.getInt("entry_id"),
                resultSet.getInt("book_id"),
                resultSet.getInt("user_id"),
                DAOUtil.getLocalDate(resultSet.getString("borrow_date")),
                DAOUtil.getLocalDate(resultSet.getString("return_date"))
            );
        }

        return entry;
    }

    @Override
    public List<Entry> getAll() throws SQLException {
        List<Entry> entries = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL.getQuery())) {

            preparedStatement.setString(1, "entries");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                entries.add(new Entry(
                        resultSet.getInt("entry_id"),
                        resultSet.getInt("book_id"),
                        resultSet.getInt("user_id"),
                        DAOUtil.getLocalDate(resultSet.getString("borrow_date")),
                        DAOUtil.getLocalDate(resultSet.getString("return_date"))
                ));
            }
        }

        return entries;
    }

    @Override
    public void add(Entry entry) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ENTRY)) {

            preparedStatement.setInt(1, entry.getBookId());
            preparedStatement.setInt(2, entry.getUserId());
            preparedStatement.setString(3, DAOUtil.getStringDate(entry.getBorrowDate()));
            preparedStatement.setString(4, DAOUtil.getStringDate(entry.getReturnDate()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.REMOVE_BY_ID.getQuery())) {

            preparedStatement.setString(1, "entries");
            preparedStatement.setString(2, "entry_id");
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }
}
