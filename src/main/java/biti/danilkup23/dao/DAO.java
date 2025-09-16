package biti.danilkup23.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    void add(T t) throws SQLException;

    void removeById(int id) throws SQLException;
}
