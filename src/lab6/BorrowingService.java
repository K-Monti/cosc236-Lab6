package lab6;

public class BorrowingService implements BorrowingServiceAPI {
	// DONE: Implement methods for borrowing
	// and returning Books
	@Override
	public boolean borrowBook(Member member, Book book) {
		if(member.getBorrowedBooks().contains(book)) {
			return false;
		}
		if(book != null && book.getIsAvailable()) {
			member.getBorrowedBooks().add(book);
			book.setIsAvailable(false);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean returnBook(Member member, lab6.Book book) {
		if(book == null) {
			return false;
		}
		if(!member.getBorrowedBooks().contains(book)) {
			return false;
		}

		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return true;
	}
}
