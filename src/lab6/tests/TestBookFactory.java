package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab6.*;
import org.junit.jupiter.api.Test;

public class TestBookFactory {
    @Test
    public void testPaperBookFactory() {
        BookFactory bookFactory = new PaperBookFactory();
        Book book = bookFactory.createBook("Paper Book Test");
        assertTrue(book instanceof PaperBook);
    }

    @Test
    public void testEBookFactory() {
        BookFactory bookFactory = new EBookFactory();
        Book book = bookFactory.createBook("EBook Test");
        assertTrue(book instanceof EBook);
    }

    @Test
    public void testAudioBookFactory() {
        BookFactory bookFactory = new AudioBookFactory();
        Book book = bookFactory.createBook("Audio Book Test");
        assertTrue(book instanceof AudioBook);
    }

    @Test
    public void testUnsupportedBookType() {
        BookFactory unsupported = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return null;
            }
        };

        Book book = unsupported.createBook("Unsupported Book Test");
        assertNull(book);
    }
}
