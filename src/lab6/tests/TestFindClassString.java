package lab6.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab6.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestFindClassString {

	
private Library library;
	private BorrowingService borrowingService;

	@BeforeEach
	void setUp() throws Exception {
        this.library = new Library(); // empty library for each test
        this.borrowingService = BorrowingService.getInstance();
	}
	
	Member member1 = new Member("Dude", borrowingService);
	Member member2 = new Member("Gal",borrowingService);
	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");

	@Test
	void FindMember() {
		library.addMember(member1);
		library.addMember(member2);
		Member member = library.findMemberByName(member1.getName());
		assertEquals(member, member1, "Found member doesn't match");
		assertEquals(library.membersCount(), 2, "There should be two members");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "There should be only one member remain");
		member = library.findMemberByName(member2.getName());
		assertNull(member, "The mmber should not hav ben found after removal from the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(),  1, "Removal of a non-existent member should not affect library");
		library.removeMember(member1);
		assertEquals(library.membersCount(), 0, "All members should have been removed");
	}

	@Test
	void FindBook() {
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		Book book = library.findBookByTitle(paperBook1.getTitle());
		assert(book == paperBook1);
		assert(library.booksCount() == 2);
		library.removeBook(paperBook2);
		assert(library.booksCount() == 1);
		book = library.findBookByTitle(paperBook2.getTitle());
		assert(book == null);
		library.removeBook(paperBook2);
		assert(library.booksCount() == 1);
		library.removeBook(paperBook1);
		assert(library.booksCount() == 0);
	}
}
