package cosc236Lab6;

import org.junit.jupiter.api.Test;

public class TestSingleton {
	
	@Test 
	void TestSingleton() {  
		BorrowingService service1 = BorrowingService.getInstance(); 
		BorrowingService service2 = BorrowingService.getInstance(); 
		assertEquals(service1, service2,"Two Singleton instances detected"); 
	}

}
