  package lab6;
//Part 6
public class BorrowingBookResult {
	
	private boolean isSuccess;
	private String borrowingMessage;


    public BorrowingBookResult() {
        this.isSuccess = false;
        this.borrowingMessage = "";
    }
	//constructor taken directly from task 3
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage){
		this.isSuccess = isSuccess; 
		this.borrowingMessage = borrowingMessage; 
	} 
	
	public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
	public boolean getSuccess() {
        return isSuccess;
    }

	public void setBorrowingMessage(String borrowingMessage) {
        this.borrowingMessage = borrowingMessage;
    }
	public String getBorrowingMessage() {
        return borrowingMessage;
    }
}
