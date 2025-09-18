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

    FOREIGN_KEY("PRAGMA foreign_keys = ON;"),

    GET_ALL_BOOKS("SELECT * FROM books;"),
    GET_BY_BOOK_ID("SELECT * FROM books WHERE (book_id = ?);"),
    ADD_BOOK("INSERT INTO books(book_title, book_author_name, book_writing_year, book_isbn, is_available) VALUES(?, ?, ?, ?, ?);"),
    REMOVE_BY_BOOK_ID("DELETE FROM books WHERE (book_id = ?);"),
    GET_BOOK_BY_ISBN("SELECT * from books WHERE (book_isbn = ?);"),

    GET_ALL_USERS("SELECT * from users"),
    GET_BY_USER_ID("SELECT * FROM users WHERE (user_id = ?);"),
    ADD_USER("INSERT INTO users(user_type, user_first_name, user_last_name, user_email) VALUES(?, ?, ?, ?);"),
    REMOVE_BY_USER_ID("DELETE FROM users WHERE (user_id = ?);"),
    GET_USER_BY_FULL_NAME("SELECT * FROM users WHERE (user_first_name = ? AND user_last_name = ?);"),

//    GET_ALL_ENTRIES("""
//            SELECT entry_id, book_title, user_first_name, user_last_name FROM entries, books, users
//            WHERE (entries.book_id = books.book_id AND entries.user_id = users.user_id);
//    """),
    GET_ALL_ENTRIES("SELECT * from entries"),
    GET_BY_ENTRY_ID("SELECT * FROM entries WHERE(entry_id = ?);"),
    IS_AVAILABLE("SELECT is_available FROM books WHERE(book_id = ?);"),
    COUNT_BORROWED_BOOKS("SELECT COUNT(*) AS count FROM entries WHERE(user_id = ?)"),
    ADD_ENTRY("INSERT INTO entries(book_id, user_id, borrow_date, return_date) VALUES(?, ?, ?, ?);"),
    REMOVE_BY_ENTRY_ID("DELETE FROM entries WHERE (entry_id = ?);"),
    GET_BORROWED_BOOKS_BY_TITLE("""
            SELECT user_first_name, user_last_name, borrow_date, return_date FROM entries, books, users
            WHERE (books.book_id = entries.book_id AND users.user_id = entries.user_id AND books.book_title = ?);
    """),
    GET_BORROWED_BOOKS_BY_USER_ID("""
            SELECT book_title, user_first_name, user_last_name, borrow_date, return_date FROM entries, books, users
            WHERE (entries.book_id = books.book_id AND users.user_id = entries.user_id AND entries.user_id = ?);
    """);

    //TODO: add query which calculate a difference between borrow and return date, compare result with max days

    private final String query;

    SQLQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
