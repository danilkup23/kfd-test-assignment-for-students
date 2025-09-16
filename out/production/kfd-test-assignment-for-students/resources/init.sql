CREATE TABLE IF NOT EXISTS books(
    book_id integer PRIMARY KEY AUTOINCREMENT,
    book_title text NOT NULL,
    book_author_name text NOT NULL,
    book_writing_year integer CHECK (book_writing_year > 0),
    book_isbn text NOT NULL UNIQUE,
    is_available boolean NOT NULL DEFAULT true
);

CREATE TABLE IF NOT EXISTS users(
    user_id integer PRIMARY KEY AUTOINCREMENT,
    user_type text NOT NULL,
    CHECK (user_type = 'GUEST' OR user_type = 'FACUSLTY' OR user_type = 'STUDENT'),
    user_first_name text NOT NULL,
    user_last_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS entries(
    entry_id integer PRIMARY KEY AUTOINCREMENT,
    book_id integer NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
    user_id integer NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

