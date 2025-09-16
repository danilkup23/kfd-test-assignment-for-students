package biti.danilkup23.dao;

import biti.danilkup23.dao.utils.DatabaseConnector;
import biti.danilkup23.dao.utils.SQLQueries;
import biti.danilkup23.model.User;
import biti.danilkup23.dao.utils.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    private static final String ADD_USER_QUERY = "INSERT INTO users(user_type, user_first_name, user_last_name, user_email) VALUES(?, ?, ?, ?);";

    @Override
    public User get(int id) throws SQLException {
        User user = null;

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_BY_ID.getQuery())) {

            preparedStatement.setString(1, "users");
            preparedStatement.setString(2, "user_id");
            preparedStatement.setInt(3, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            user = DAOUtil.getUser(resultSet);
        }

        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL.getQuery())) {

            preparedStatement.setString(1, "users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(DAOUtil.getUser(resultSet));
            }
        }

        return users;
    }

    @Override
    public void add(User user) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY)) {
            preparedStatement.setString(1, user.getType());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeById(int id) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.REMOVE_BY_ID.getQuery())) {
            preparedStatement.setString(1, "users");
            preparedStatement.setString(2, "user_id");
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }
}
