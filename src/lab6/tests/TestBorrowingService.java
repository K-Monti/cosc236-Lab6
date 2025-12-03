package cosc236Lab6;
//package lab6.tests;
//import lab6.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestBorrowingService {
	
	@BeforeEach
	void setUp() {
		BorrowingService service = new BorrowingService();
	    Book book = new Book("1776", "David McCullough");
	    Member member = new Member("Jane");
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
	    assertEquals("Book dosen't exist, borrowing unsuccessful", result.getBorrowingMessage());
	}

	
	
}
