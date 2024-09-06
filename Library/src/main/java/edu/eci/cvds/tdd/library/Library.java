package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.LocalDateTime;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (book == null){
            return false;
        }
        if (books.containsKey(book)){
            int newAmount = books.get(book) + 1;
            books.put(book, newAmount);
            return true;
        }
        if (!books.containsKey(book)){
            books.put(book,1);
            return true;
        }
        return false;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        Book book = getBookWithIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
        User user = getUserWithId(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
        if (!books.containsKey(book) || books.get(book) <= 0) {
            throw new IllegalStateException("The book is not available for loan.");
        }
        for (Loan l : loans) {
            if (l.getUser().equals(user) && l.getBook().equals(book) && l.getStatus() == LoanStatus.ACTIVE) {
                throw new IllegalStateException("The user already has an active loan for this book.");
            }
        }
        Loan newLoan = new Loan();
        newLoan.setBook(book);
        newLoan.setUser(user);
        newLoan.setStatus(LoanStatus.ACTIVE);
        newLoan.setLoanDate(LocalDateTime.now());
        loans.add(newLoan);
        books.put(book, books.get(book) - 1);
        return newLoan;
    }

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        Loan existingLoan = null;
        if (loan == null) return loan;
        for (Loan l : loans) {
            if (l.equals(loan)) {
                existingLoan = l;
                break;
            }
        }
        if (existingLoan == null) {
            throw new IllegalArgumentException("The loan does not exist.");
        }
        existingLoan.setStatus(LoanStatus.RETURNED);
        existingLoan.setReturnDate(LocalDateTime.now());
        Book book = existingLoan.getBook();
        books.put(book, books.get(book) + 1);
        return existingLoan;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    /**
     * Retrieves a {@link edu.eci.cvds.tdd.library.book.Book} object from the collection based on its ISBN.
     *
     * @param isbn The ISBN of the book to be searched.
     * @return The {@link edu.eci.cvds.tdd.library.book.Book} object if found, otherwise returns {@code null}.
     */
    private Book getBookWithIsbn(String isbn){
        for (Book b : books.keySet()) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Retrieves a {@link edu.eci.cvds.tdd.library.user.User} object from the collection based on its ID.
     *
     * @param userId The ID of the user to be searched.
     * @return The {@link edu.eci.cvds.tdd.library.user.User} object if found, otherwise returns {@code null}.
     */
    private User getUserWithId(String userId){
        for (User u : users) {
            if (u.getId().equals(userId)) {
                return u;
            }
        }
        return null;
    }
}