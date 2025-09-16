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
        int id = rs.getInt("user_id");
        String type = rs.getString("user_type");
        String firstName = rs.getString("user_first_name");
        String lastName = rs.getString("user_last_name");
        String email = rs.getString("user_email");

        User user = null;

        switch (type) {
            case "STUDENT":
                user =  new Student(id, type, firstName, lastName, email);
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

    public static LocalDate getLocalDate(String date) {
        String[] dateSlices = date.split("\\.");
        return LocalDate.of(Integer.parseInt(dateSlices[2]), Integer.parseInt(dateSlices[1]), Integer.parseInt(dateSlices[0]));
    }

    public static String getStringDate(LocalDate date) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(date.getDayOfMonth());
        stringBuilder.append('.');

        stringBuilder.append(date.getMonth());
        stringBuilder.append('.');

        stringBuilder.append(date.getYear());
        stringBuilder.append('.');

        return stringBuilder.toString();
    }
}
