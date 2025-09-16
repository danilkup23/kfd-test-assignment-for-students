package biti.danilkup23.dao.utils;

public enum SQLQueries {
    TABLE_BOOKS("""
    CREATE TABLE IF NOT EXISTS books(
        book_id integer PRIMARY KEY AUTOINCREMENT,
        book_title text NOT NULL,
        book_author_name text NOT NULL,
        book_writing_year integer CHECK (book_writing_year > 0),
        book_isbn text NOT NULL UNIQUE,
        is_available boolean NOT NULL DEFAULT true
    );
    """),

    TABLE_USERS("""
    CREATE TABLE IF NOT EXISTS users(
        user_id integer PRIMARY KEY AUTOINCREMENT,
        user_type text NOT NULL CHECK (user_type = 'GUEST' OR user_type = 'FACULTY' OR user_type = 'STUDENT'),
        user_first_name text NOT NULL,
        user_last_name text NOT NULL,
        user_email text
    );
    """),

    TABLE_ENTRIES("""
    CREATE TABLE IF NOT EXISTS entries(
        entry_id integer PRIMARY KEY AUTOINCREMENT,
        book_id integer NOT NULL,
        user_id integer NOT NULL,
        borrow_date text NOT NULL,
        return_date text,
        FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
    );
    """),

    GET_BY_ID("SELECT * FROM ? WHERE (? = ?);"),

    GET_ALL("SELECT * FROM ?;"),

    REMOVE_BY_ID("DELETE FROM ? WHERE (? = ?);");

    private final String query;

    SQLQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
