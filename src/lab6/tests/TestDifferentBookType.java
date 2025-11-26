package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab6.Library;
import lab6.Book;
import lab6.AudioBook;
import lab6.EBook;
import lab6.PaperBook;

public class TestDifferentBookType {

    @Test
    void libraryHandlesDifferentBookTypes() {
        Library library = new Library();
        Book pb = new PaperBook("Paper Book");
        Book eb = new EBook("Electronic Book");
        Book ab = new AudioBook("Audio Book");

        library.addBook(pb);
        library.addBook(eb);
        library.addBook(ab);

        assertEquals(3, library.booksCount());
        assertEquals(pb, library.findBookByTitle("Paper Book"));
        assertEquals(eb, library.findBookByTitle("Electronic Book"));
        assertEquals(ab, library.findBookByTitle("Audio Book"));
    }
}
