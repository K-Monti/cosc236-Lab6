package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab6.Member;
import lab6.Library;
import lab6.PaperBook;

class TestAddRemoveMembers {

	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");
	
	@Test
	void AddMember() {
		
		assertEquals(library.membersCount(), 0, "Should be no members after initialization");	
		library.addMember(member1);	
		assertEquals(library.membersCount(), 1, "One member should have been added");	
		library.addMember(member2);
		assertEquals(library.membersCount(), 2, "Two members should have been added");	
		
	}
	
	@Test
	void RemoveMembersMember() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should have been in the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "Only one member should remain");
	}
	@Test
	void RemoveMemberString() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should have been in the library");
		library.removeMember("Dude");
		assertEquals(library.membersCount(), 1, "Only one member should remain");
	}

	@Test
	void RemoveMemberWithBooks() {
		
		AddMember();
		assertEquals(library.membersCount(), 2, "Two members should be in the library");
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		assertEquals(library.booksCount(), 2, "Two books should be in the library");
		
		member1.borrowBook(paperBook1);
		member1.borrowBook(paperBook2);
		assertEquals(member1.borrowedBooksCount(), 2, "Should be two borrowed books");
		assertFalse(paperBook1.getIsAvailable(), "Book should be not available");
		assertFalse(paperBook2.getIsAvailable(), "Book should be not available");
		
		library.removeMember(member1);
		assertEquals(library.membersCount(), 1, "Only one member should remain");
		assertEquals(library.booksCount(), 2, "Two books should be in the library");
		assertTrue(paperBook1.getIsAvailable(), "Book should be available");
		assertTrue(paperBook2.getIsAvailable(), "Book should be available");
				
	}
}
