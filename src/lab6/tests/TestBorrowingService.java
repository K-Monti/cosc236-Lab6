package lab6.tests;
import lab6.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestBorrowingService {
    private BorrowingService service;
    private Book book;
    private Member member;

	@BeforeEach
	void setUp() {
		service = BorrowingService.getInstance();
	    book = new PaperBook("1776");
	    member = new Member("Jane", service);
	}

	@Test
	void testBorrowedBook() { //a memeber shouldn't be able to borrow a book they currently have borrowed
		service.borrowBook(member, book);

		BorrowingBookResult result = service.borrowBook(member, book);
		assertEquals("Member has already borrowed this book, cannot be borrowed", result.getBorrowingMessage());
	}

	@Test
	void testBorrowNullBook() {	//testing borrowing a book which dosen't exist
		BorrowingBookResult result = service.borrowBook(member, null);
	    assertEquals("Book doesn't exist, borrowing unsuccessful", result.getBorrowingMessage());
	}



}
