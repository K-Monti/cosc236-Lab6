package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab6.*;


class TestRemoveMemberWithBooks {

	Library library;
	Member member;
	PaperBook paperBook1;
	PaperBook paperBook2;
	PaperBook paperBook3;

	@BeforeEach
	void setUp() throws Exception {
		this.library = new Library(); // Fresh library: one member, two tests
		paperBook1 = new PaperBook("Dune");
		paperBook2 = new PaperBook("1984");
		paperBook3 = new PaperBook("Moby Dick");
		member = new Member("Dude", BorrowingService.getInstance());
		library.addMember(member);
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		library.addBook(paperBook3);
	}
	
	@Test
	void removeMemberReturnBooks() {
		
		member.borrowBook(paperBook1);
		member.borrowBook(paperBook2);
		member.borrowBook(paperBook3);
		assertAll("Check inital library state", 
			() -> assertEquals(library.membersCount(),1),
			() -> assertEquals(library.booksCount(),3),
			() -> assertFalse(paperBook1.getIsAvailable()),
			() -> assertFalse(paperBook2.getIsAvailable()),
			() -> assertEquals(member.borrowedBooksCount(),3)
		);
		
		library.removeMember(member);
		
		assertEquals(library.membersCount(),0);
		assertEquals(library.booksCount(),3);
		assertTrue(paperBook1.getIsAvailable());
		assertTrue(paperBook2.getIsAvailable());
		assertTrue(paperBook3.getIsAvailable());
		assertEquals(member.borrowedBooksCount(),0);
	}

}
