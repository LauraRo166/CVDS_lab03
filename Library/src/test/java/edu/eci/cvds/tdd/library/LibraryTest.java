package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Library library;

    /**
     * Default constructor for test class Qupripoobv1
     */
    public LibraryTest() {

    }

    @BeforeEach
    public void setUp() {
        library = new Library();
        User user1 = new User();
        user1.setName("John Doe");
        user1.setId("1");
        book1 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0618260300");
        library.addBook(book1);
        library.addUser(user1);
    }
    @Test
    public void shouldAddANewBook() {

        Book book = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling","978-0747532699");
        boolean answer = library.addBook(book1);
        assertTrue(answer);

    }

    @Test
    public void shouldAddExistingBook() {

        Book book = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling","978-0747532699");
        boolean answer = library.addBook(book1);
        assertTrue(answer);

    }



}
