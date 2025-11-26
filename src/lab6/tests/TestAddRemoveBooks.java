package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;


import lab6.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Added test cases for EBook and Audio Book
class TestAddRemoveBooks {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	Book paperBook1 = new PaperBook("Dune");
	Book paperBook2 = new PaperBook("1984");
	Book paperBook3 = new PaperBook("Moby Dick");

    EBook eBook = new EBook("Alice in wonderland");
    AudioBook audioBook = new AudioBook("Harry Potter");

	Member member = new Member("Grady Booch");
	
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		library.addBook(paperBook3);
        library.addBook(eBook);
        library.addBook(audioBook);
		assertEquals(library.booksCount(), 5, "There should be 5 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 5, "There should be 5 books in the library");
		library.removeBook(paperBook2);
		library.removeBook(paperBook3);
        library.removeBook(eBook);
		assertEquals(library.booksCount(), 2, "There should be only 2 books left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 5, "There should be 5 books in the library");
		library.removeBook("Dune");
        library.removeBook("Harry Potter");
		assertEquals(library.booksCount(), 3, "There should be only three book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 5, "There should be 5 books in the library");
		
		member.borrowBook(paperBook1);
        member.borrowBook(eBook);
        member.borrowBook(audioBook);
		assertEquals(member.borrowedBooksCount(), 3, "Should be 3 borrowed books");
		
		library.removeBook(paperBook1);
        library.removeBook(eBook);
		assertEquals(library.booksCount(), 3, "There should be only three book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 3, "The 3 books should stay with member"); //

        assertTrue(member.getBorrowedBooks().contains(paperBook1), "Member should still have the paper book");
        assertTrue(member.getBorrowedBooks().contains(eBook), "Member should still have the eBook");
    }
	
	
}
