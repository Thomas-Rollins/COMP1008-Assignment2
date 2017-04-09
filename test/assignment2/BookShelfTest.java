/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Rollins
 */
public class BookShelfTest {
    private BookShelf validShelf1, validShelf2, validShelf3;
    private Book validBook;
    private Book validBook2;
    private Book validBook3;
    private Book validBook4;
    private Book validBook5;
    
    public BookShelfTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validShelf1 = new BookShelf(5, 8);
        validShelf2 = new BookShelf(4,5);
        validShelf3 = new BookShelf(1,3);
        
       validBook = new Book("Title", "Brent Weeks", "978-92-95055-02-5", "Cover Artist", "Series1",
                "publisher", LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
       validBook2 = new Book("Title", "Another Author", "978-92-95055-02-5", "Cover Artist", "Series1",
                "publisher", LocalDate.of(2007, Month.JANUARY, 1), 19.99, 100, 50);
       validBook3 = new Book("Title", "Author Two", "978-92-95-02-5", "Cover Artist", "Series2",
                "publisher", LocalDate.of(2006, Month.DECEMBER, 31), 19.99, 100, 50);
       validBook4 = new Book("Title", "Author Three", "978-92-95-02-5", "Cover Artist", "Series3",
                "publisher", null, 19.99, 100, 50);
       validBook5 = new Book("Title", "Author Three", "978-92-95951-02-5", "Cover Artist", null,
               "publisher", LocalDate.of(2018, Month.DECEMBER, 31), 19.99, 100, 50);
       
        validShelf1.addBook(validBook);
        validBook.addGenres("fantasy");
        validShelf1.addBook(validBook2);
        validBook2.addGenres("adventure");
        validShelf1.addBook(validBook3);
        validShelf1.addBook(validBook4);
        validBook4.addGenres("Romance");
        validShelf1.addBook(validBook5);
    
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetMaxRows() {
        System.out.println("getMaxRows");
        BookShelf instance = validShelf1;
        int expResult = 5;
        int result = instance.getMaxRows();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxColumns() {
        System.out.println("getMaxColumns");
        BookShelf instance = validShelf1;
        int expResult = 8;
        int result = instance.getMaxColumns();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateConstructor() {
        System.out.println("ValidateConstructor");
        try {
            BookShelf instance = new BookShelf(-1, 0);
            fail("Should have thown an Exception");
        }
        catch(IllegalArgumentException e){}
    }
    @Test
    public void testValidateConstructor2() {
        System.out.println("ValidateConstructor2");
        try {
            BookShelf instance = new BookShelf(1, 0);
            fail("Should have thown an Exception");
        }
        catch(IllegalArgumentException e){}
    }

    @Test
    public void testGetTotalCapacity() {
        System.out.println("getTotalCapacity");
        BookShelf instance = validShelf1;
        int expResult = 40;
        int result = instance.getTotalCapacity();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllBooksOnShelf() {
        System.out.println("getAllBooksOnShelf");
        BookShelf instance = validShelf1;
        ArrayList<Book> expResult = new ArrayList();
        expResult.add(validBook);
        expResult.add(validBook2);
        expResult.add(validBook3);
        expResult.add(validBook4);
        expResult.add(validBook5);
        ArrayList result = instance.getAllBooksOnShelf();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNumberOfBooksOnShelf() {
        System.out.println("getNumberOfBooksOnShelf");
        BookShelf instance = validShelf1;
        int expResult = 5;
        int result = instance.getNumberOfBooksOnShelf();
        assertEquals(expResult, result);
    }
 
    @Test
    public void testAddBook() {
        System.out.println("testAddBook");
        BookShelf instance = validShelf3;
        instance.addBook(validBook);
        instance.addBook(validBook);
        instance.addBook(validBook);
        
        try {
            instance.addBook(validBook);
            fail("Should have thrown an Exception");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        BookShelf instance = validShelf1;
        ArrayList<Book> expResult = new ArrayList<>();
        
        expResult.add(validBook2);
        expResult.add(validBook3);
        expResult.add(validBook4);
        expResult.add(validBook5);
        
        instance.removeBook(validBook);
        assertEquals(expResult, instance.getAllBooksOnShelf());
    }
    
    @Test
    public void testGetAuthorListRangeOnShelf()
    {
        System.out.println("getAuthorListRangeOnShelf");
        BookShelf instance = validShelf1;
        String expResult ="Author - Weeks";
        assertEquals(expResult, instance.getAuthorListRangeOnShelf());
    }
    
    @Test
    public void testGetAuthorListRangeOnShelf2()
    {
        System.out.println("getAuthorListRangeOnShelf2");
        BookShelf instance = validShelf2;
        String expResult ="No Authors Listed";
        assertEquals(expResult, instance.getAuthorListRangeOnShelf());
    }
    
    @Test
    public void testGetAuthorListRangeOnShelf3()
    {
        System.out.println("getAuthorListRangeOnShelf2");
        BookShelf instance = validShelf2;
        instance.addBook(validBook);
        String expResult = "Weeks";
        assertEquals(expResult, instance.getAuthorListRangeOnShelf());
    }
    
    @Test
    public void testGetGenresOnShelf()
    {
        System.out.println("getGenresOnShelf");
        BookShelf instance = validShelf1;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("ADVENTURE");
        expResult.add("FANTASY");
        expResult.add("ROMANCE");
        assertEquals(expResult, instance.getGenresOnShelf());
    }
    
    @Test
    public void testGetShelfGenre()
    {
        System.out.println("getShelfGenre");
        BookShelf instance = validShelf1;
        String expResult = "ADVENTURE";
        assertEquals(expResult, instance.getShelfGenre());
    }
    
    @Test
    public void testGetShelfGenre2()
    {
        System.out.println("getShelfGenre2");
        BookShelf instance = validShelf2;
        String expResult = "No Genre Listed";
        assertEquals(expResult, instance.getShelfGenre());
    }
    
}
