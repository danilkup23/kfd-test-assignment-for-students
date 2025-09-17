package biti.danilkup23.dao.utils;

import biti.danilkup23.model.Faculty;
import biti.danilkup23.model.Guest;
import biti.danilkup23.model.Student;
import biti.danilkup23.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAOUtil {
    public static User getUser(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int id = rs.getInt("user_id");
            String type = rs.getString("user_type");
            String firstName = rs.getString("user_first_name");
            String lastName = rs.getString("user_last_name");
            String email = rs.getString("user_email");

            User user = null;

            switch (type) {
                case "STUDENT":
                    user = new Student(id, type, firstName, lastName, email);
                    break;
                case "GUEST":
                    user = new Guest(id, type, firstName, lastName, email);
                    break;
                case "FACULTY":
                    user = new Faculty(id, type, firstName, lastName, email);
                    break;
                default:
                    break;
            }

            return user;
        }
        return null;
    }
}
