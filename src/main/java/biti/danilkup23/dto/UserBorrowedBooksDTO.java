package biti.danilkup23.dto;

import java.time.LocalDate;

public class UserBorrowedBooksDTO {
    private String bookTitle;
    private String firstName;
    private String lastName;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public UserBorrowedBooksDTO(String bookTitle, String firstName, String lastName, LocalDate borrowDate, LocalDate returnDate) {
        this.bookTitle = bookTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
