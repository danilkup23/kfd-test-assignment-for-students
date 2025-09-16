package biti.danilkup23.model;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String authorName;
    private int writingYear;
    private String isbn;
    private boolean isAvailable;

    public Book(int id, String title, String authorName, int writingYear, String ISBN, boolean isAvailable) {
        this.id = id;
        setTitle(title);
        setAuthorName(authorName);
        setWritingYear(writingYear);
        setIsbn(ISBN);
        setIsAvailable(isAvailable);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getWritingYear() {
        return writingYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("The title of the book cannot be empty!");
        }
        this.title = title.trim();
    }

    public void setAuthorName(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("The author's name cannot be empty!");
        }
        this.authorName = authorName.trim();
    }

    public void setWritingYear(int writingYear) {
        int currentYear = LocalDate.now().getYear();
        if (writingYear < 0 || writingYear > currentYear) {
            throw new IllegalArgumentException("Illegal writing year of the book!");
        }
        this.writingYear = writingYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
