package lab6;

public class BorrowingService implements BorrowingServiceAPI {
	// DONE: Implement methods for borrowing
	// and returning Books

	//Singleton implementation:
	private static BorrowingService instance; // private member
	private int borrowingLimit; // to restrict the count of borrowed books
	private BorrowingService() { // private constructor  
		borrowingLimit = 3; 
	}
	public static BorrowingService getInstance( ) { 
		// DONE
		// Implement Singleton pattern. 
		if (instance == null) {                      
            synchronized (BorrowingService.class) { 
                if (instance == null) {             
                    instance = new BorrowingService();
                }
            }
        }
		return instance; 
	}
		
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		BorrowingBookResult result = new BorrowingBookResult();
			
		if(member.getBorrowedBooks().contains(book)) { //The book is already borrowed by the same member 
			result.setSuccess(false);
			result.setBorrowingMessage("Member has already borrowed this book, cannot be borrowed");
			return result;
		}
		if(book != null && book.getIsAvailable()) { //The book is available
			member.getBorrowedBooks().add(book);
			book.setIsAvailable(false);

			result.setSuccess(true);
			result.setBorrowingMessage("The member has borrowed the book successfully");
			return result;
		}else {
			result.setSuccess(false);
			result.setBorrowingMessage("The member has borrowed unsuccessfully");
			return result;
		}	
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		BorrowingBookResult result = new BorrowingBookResult();
		
		if(book == null) { //The book dosen't exist
			result.setSuccess(false);
			result.setBorrowingMessage("Book dosen't exist, borrowing unsuccessful");
			return result;
		}
		if(!member.getBorrowedBooks().contains(book)) { //The member has not borrowed the book
			result.setSuccess(false);
			result.setBorrowingMessage("The member has not borrowed the book, borrowing unsuccessful");
			return result;
		}

		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		
		result.setSuccess(true);
		result.setBorrowingMessage("Book has been successfully returned");
		return result;
	}
}



