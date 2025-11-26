package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab6.AudioBook;
import lab6.EBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab6.Member;
import lab6.PaperBook;

// Added tests for EBook and Audio Book
class TestBorrowBooks {

	Member member1;
	Member member2;
	
	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");

    EBook eBook = new EBook("Alice in wonderland"); //Added EBook to test different types
    AudioBook audioBook = new AudioBook("Harry Potter"); //Added AudioBook to test different types
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		paperBook1.setIsAvailable(true);
		paperBook2.setIsAvailable(true);
        eBook.setIsAvailable(true);
        audioBook.setIsAvailable(true);

	}
	@Test
	void borrowBookBook() {
		
		// borrow first paper book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(paperBook1.getIsAvailable(), "Paper Book 1 must be available");
		member1.borrowBook(paperBook1);
		assertFalse(paperBook1.getIsAvailable(),"Paper Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second paper book
		assertTrue(paperBook2.getIsAvailable(),"Paper Book must be available");
		member1.borrowBook(paperBook2);
		assertFalse(paperBook1.getIsAvailable(), "Paper Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book count should be 2");

        // borrow EBook
        assertTrue(eBook.getIsAvailable(), "EBook must be available");
        member1.borrowBook(eBook);
        assertFalse(eBook.getIsAvailable(), "EBook must be not available");
        assertEquals(member1.borrowedBooksCount(), 3, "The book count should be 3");

        // borrow AudioBook
        assertTrue(audioBook.getIsAvailable(), "Audio Book should be available");
        member1.borrowBook(audioBook);
        assertFalse(audioBook.getIsAvailable(), "Audio Book should not be available");
        assertEquals(member1.borrowedBooksCount(), 4, "Borrowed books count should be 4");

	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(paperBook1.getIsAvailable(), "Book 1 should be available");
		assertTrue(paperBook2.getIsAvailable(), "Book 2 should be available");
        assertTrue(eBook.getIsAvailable(), "EBook should be available");
        assertTrue(audioBook.getIsAvailable(), "AudioBook should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );

		member1.borrowBook(paperBook1);
		member1.borrowBook(paperBook2);
        member1.borrowBook(eBook);
        member1.borrowBook(audioBook);

		assertEquals(member1.borrowedBooksCount(),4, "The count of books must be 2");
		assertFalse(paperBook1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(paperBook2.getIsAvailable(), "Book 2 should not be available");
        assertFalse(eBook.getIsAvailable(), "EBook should not be available");
        assertFalse(audioBook.getIsAvailable(), "AudioBook should not be available");
		
		// return first paper book
		member1.returnBook(paperBook1);
		assertTrue(paperBook1.getIsAvailable(), "Paper Book 1 should be available after return");
		assertEquals(member1.borrowedBooksCount(), 3, "Count of books must be 3");

		// return second paper book
		member1.returnBook(paperBook2);
		assertTrue(paperBook2.getIsAvailable(), "Paper Book 2 should be available after return");
		assertEquals(member1.borrowedBooksCount(), 2, "Count of books must be 2");

        // return EBook
        member1.returnBook(eBook);
        assertTrue(eBook.getIsAvailable(), "EBook should be available after return");
        assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");

        // return Audio Book
        member1.returnBook(audioBook);
        assertTrue(audioBook.getIsAvailable(), "AudioBook should be available after return");
        assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
	}

}
