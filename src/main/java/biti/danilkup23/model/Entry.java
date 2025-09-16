package biti.danilkup23.model;

import java.time.LocalDate;

public class Entry {
    private int id;
    private int bookId;
    private int userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Entry(int id, int bookId, int userId, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        setBookId(bookId);
        setUserId(userId);
        setBorrowDate(borrowDate);
        setReturnDate(returnDate);
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
