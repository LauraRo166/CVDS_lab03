package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.Library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Library library;
    private Book book1;
    private User user1;

    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest() {
    }

    @BeforeEach
    public void setUp() {
        library = new Library();
        user1 = new User();
        user1.setName("John Doe");
        user1.setId("1");
        book1 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0618260300");
        library.addBook(book1);
        library.addUser(user1);
    }

    @Test
    public void shouldLoanABook() {

        Loan loan = library.loanABook("1", "978-0618260300");
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertEquals(LocalDateTime.now(), loan.getLoanDate());
    }

    @Test
    public void shouldNotLoanBookWhenUserAlreadyHasIt() {

        try {
            library.addBook(book1);
            Loan initialLoan = library.loanABook("1", "978-0618260300");
            assertEquals(LoanStatus.ACTIVE, initialLoan.getStatus());
            library.loanABook("1", "978-0618260300");
            fail("Expected IllegalStateException was not thrown.");
        } catch (IllegalStateException e) {
            assertEquals("The user already has an active loan for this book.", e.getMessage());
        }
    }

    @Test
    public void shouldReturnLoanSuccessfully() {
        Loan loan1 = library.loanABook("1","978-0618260300");
        Loan returnedLoan = library.returnLoan(loan1);
        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertEquals(LocalDateTime.now().getDayOfYear(), returnedLoan.getReturnDate().getDayOfYear());
    }

    @Test
    public void shouldNotLoanBookToNonexistentUser() {
        String nonexistentUserId = "234567";
        String isbn = book1.getIsbn();

        try {
            library.loanABook(nonexistentUserId, isbn);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("User with ID " + nonexistentUserId + " does not exist.", e.getMessage());
        }

    }

    @Test

    public void shouldReturnNullIfLoanDoesNotExist() {
        Loan returnedLoan = library.returnLoan(null);
        assertNull(returnedLoan);
    }

    @Test
    public void shouldNotLoanNonexistentBook() {
        String userId = user1.getId();
        String nonexistentIsbn = "nonexistentIsbn";

        try {
            library.loanABook(userId, nonexistentIsbn);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Book with ISBN " + nonexistentIsbn + " does not exist.", e.getMessage());
        }
    }

    @Test
    public void shouldReturnLoanAlreadyReturned() {
        Loan loan1 = library.loanABook("1", "978-0618260300");
        Loan returnedLoan1 = library.returnLoan(loan1);
        Loan returnedLoan2 = library.returnLoan(loan1);
        assertEquals(LoanStatus.RETURNED, returnedLoan2.getStatus());
    }

    @Test
    public void shouldNotLoanABookIfItIsNotAvailable()  {

        String userId = user1.getId();
        String isbn = book1.getIsbn();
        library.loanABook(userId, isbn);
        try {
            library.loanABook(userId, isbn);
            fail("Expected IllegalStateException was not thrown.");
        } catch (IllegalStateException e) {
            assertEquals("The book is not available for loan.", e.getMessage());
        }
    }

}
