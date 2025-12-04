package lab6.tests;

import lab6.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSingleton {

    @Test
    void testSingleton() {
        BorrowingService service1 = BorrowingService.getInstance();
        BorrowingService service2 = BorrowingService.getInstance();
        assertEquals(service1, service2,"Two Singleton instances detected");
    }

}
