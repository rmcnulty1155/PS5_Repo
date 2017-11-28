package pkgTest;

import java.util.Calendar;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;

public class BookTest {
	
//Note: Tests only worked when program was run on a PC. With Mac, Java could not locate XML file... I think it has to do with the file notation
	
	@Test 
	public void TestGettingBook1() throws BookException {
		Book b = Book.GetBook("bk101");
		assertEquals(b.getAuthor(),"Gambardella, Matthew");
	}
	
	@Test (expected = BookException.class) 
	public void TestGettingBook2() throws BookException {
		Book.GetBook("bk1");
	}
	
	@Test
	public void TestAddingBook1() throws BookException {
		Book b = new Book();
		b.setAuthor("Ryan McNulty");
		b.setTitle("The sad coder");
		b.setGenre("Reality");
		b.setDescription("A senior ChemE struggles with basic coding");
		b.setId("bk113");
		
		Calendar d1 = GregorianCalendar.getInstance();
		d1.set(2017, Calendar.NOVEMBER,27);
		Date date1 = d1.getTime();
		
		b.setPublish_date(date1);
		
		b.setPrice(50.00);
		
		Book.AddBook(1, b);
		
		Book.GetBook("bk113");
	}
	
	@Test (expected = BookException.class)
	public void TestAddingBook2() throws BookException {
		Book b = new Book();
		b.setId("bk101");
		Book.AddBook(1, b);
	}
	
}
