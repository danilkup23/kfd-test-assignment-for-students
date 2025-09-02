package entities;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String authorName;
    private int writingYear;
    private long ISBN;

    public Book(int id, String title, String authorName, int writingYear, long ISBN) {
        this.id = id;  
        setTitle(title);
        setAuthorName(authorName);
        setWritingYear(writingYear);
        setISBN(ISBN);
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

    public long getISBN() {
        return ISBN;
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

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }


}
