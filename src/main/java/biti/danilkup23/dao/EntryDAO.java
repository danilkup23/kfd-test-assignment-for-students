package biti.danilkup23.dao;

import biti.danilkup23.dao.utils.DAOUtil;
import biti.danilkup23.dao.utils.DatabaseConnector;
import biti.danilkup23.dao.utils.SQLQueries;
import biti.danilkup23.dto.BorrowedBooksDTO;
import biti.danilkup23.model.Entry;
import biti.danilkup23.model.User;
import biti.danilkup23.view.utils.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryDAO implements DAO<Entry> {

    @Override
    public Entry get(int id) throws SQLException {
        Entry entry = null;

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_BY_ENTRY_ID.getQuery())) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            entry = new Entry(
                resultSet.getInt("entry_id"),
                resultSet.getInt("book_id"),
                resultSet.getInt("user_id"),
                PrintUtil.getLocalDate(resultSet.getString("borrow_date")),
                PrintUtil.getLocalDate(resultSet.getString("return_date"))
            );
        }

        return entry;
    }

    @Override
    public List<Entry> getAll() throws SQLException {
        List<Entry> entries = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL_ENTRIES.getQuery())) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                entries.add(new Entry(
                        resultSet.getInt("entry_id"),
                        resultSet.getInt("book_id"),
                        resultSet.getInt("user_id"),
                        PrintUtil.getLocalDate(resultSet.getString("borrow_date")),
                        PrintUtil.getLocalDate(resultSet.getString("return_date"))
                ));
            }
        }

        return entries;
    }

    @Override
    public void add(Entry entry) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement availablePreparedStatement = connection.prepareStatement(SQLQueries.IS_AVAILABLE.getQuery());
            PreparedStatement countBorrowedBooksPreparedStatement = connection.prepareStatement(SQLQueries.COUNT_BORROWED_BOOKS.getQuery());
            PreparedStatement userPreparedStatement = connection.prepareStatement(SQLQueries.GET_BY_USER_ID.getQuery());
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_ENTRY.getQuery())) {

            availablePreparedStatement.setInt(1, entry.getBookId());
            boolean availableStatus = availablePreparedStatement.executeQuery().getBoolean("is_available");

            countBorrowedBooksPreparedStatement.setInt(1, entry.getUserId());
            int countBorrowedBooks = countBorrowedBooksPreparedStatement.executeQuery().getInt("count");

            // TODO: fix some shit
            userPreparedStatement.setInt(1, entry.getUserId());
            var user = DAOUtil.getUser(userPreparedStatement.executeQuery());

            if (availableStatus && countBorrowedBooks < user.getMaxBooks()) {
                preparedStatement.setInt(1, entry.getBookId());
                preparedStatement.setInt(2, entry.getUserId());
                preparedStatement.setString(3, PrintUtil.getStringDate(entry.getBorrowDate()));
                preparedStatement.setString(4, PrintUtil.getStringDate(entry.getReturnDate()));
                preparedStatement.executeUpdate();
            }
            else throw new SQLException();
        }
    }

    @Override
    public void removeById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.REMOVE_BY_ENTRY_ID.getQuery())) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<BorrowedBooksDTO> getBorrowedBooksByTitle(String title) throws SQLException{
        List<BorrowedBooksDTO> borrowedBooksDTOList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_BORROWED_BOOKS_BY_TITLE.getQuery())) {

            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                borrowedBooksDTOList.add(new BorrowedBooksDTO(
                    resultSet.getString("user_first_name"),
                    resultSet.getString("user_last_name"),
                    PrintUtil.getLocalDate(resultSet.getString("borrow_date")),
                        PrintUtil.getLocalDate(resultSet.getString("return_date"))
                ));
            }
        }

        return borrowedBooksDTOList;
    }
}
