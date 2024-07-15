import exam.book.BookUtil;
import exam.book.OutOfStockException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookUtilTests {
    //Requires JUNIT

    @Test
    void testAddBook() {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        assertEquals(1, bookUtil.getBooks().size());
    }

    @Test
    void testAddExitingBook() {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        assertEquals(1, bookUtil.getBooks().size());
    }

    @Test
    void testSellBook() throws OutOfStockException {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        bookUtil.sellBook("B123B", 10);
        assertEquals(285, bookUtil.getBookInfo("B123B").getStockAmount());
    }

    @Test
    void testRemoveNonExistingBook() throws OutOfStockException {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        boolean result = bookUtil.sellBook("B123A", 20);
        assertFalse(result);
    }

    @Test
    void testOutOfStock() {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        assertThrows(OutOfStockException.class, () -> bookUtil.sellBook("B123B", 300));
    }

    @Test
    void testGetOutOfStock() throws OutOfStockException {
        BookUtil bookUtil = new BookUtil();
        bookUtil.addBookToStock("B123B", "Harry Potter", 23.50, 295);
        bookUtil.sellBook("B123B", 295);
        assertEquals(1, bookUtil.getOutOfStockIds().size());
    }


}
