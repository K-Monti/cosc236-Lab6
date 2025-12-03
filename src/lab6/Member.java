package lab6;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency

	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	
	public void borrowBook(Book book){
		BorrowingBookResult borrowingResult =  borrowingService.borrowBook(this, book); 
		System.out.println("Success: " + borrowingResult.getSuccess + ": " + borrowingResult.getBorrowingMessage());
	}

	public void returnBook(Book book) {
		BorrowingBookResult returningResult =  borrowingService.returnBook(this, book);
		System.out.println("Success: " + returningResult.getSuccess + ": " + returningResult.getBorrowingMessage());	
	}

	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}

