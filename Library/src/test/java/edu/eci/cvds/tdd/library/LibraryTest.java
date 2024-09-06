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
    public void shouldAddANewBook() {
        Book book = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "978-0747532699");
        boolean answer = library.addBook(book);
        assertTrue(answer);
    }

    @Test
    public void shouldAddExistingBook() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "978-0618260300");
        boolean answer = library.addBook(book);
        assertTrue(answer);
    }

    @Test
    public void shouldNotAddNullBook() {

        boolean result = library.addBook(null);
        assertFalse(result);
    }


}


