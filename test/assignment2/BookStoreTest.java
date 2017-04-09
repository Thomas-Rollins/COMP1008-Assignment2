/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
public class BookStoreTest {
    private Book validBook;
    private Book validBook2;
    private Book validBook3;
    private Book validBook4;
    private Book validBook5;
    
    
    private BookShelf validShelf1, validShelf2, validShelf3;
    
    private BookStore validStore, validStore2;
    public BookStoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
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
       
       validBook2.addGenres("FANTASY");
       validBook2.addGenres("ADVENTURE");
        
       validShelf1 = new BookShelf(5, 8);
       validShelf2 = new BookShelf(4, 5);
       validShelf3 = new BookShelf(6, 6);
       
       validStore = new BookStore(4);
       
       validStore2 = new BookStore(3);

       validShelf2.addBook(validBook);

       validShelf2.addBook(validBook2);
       validShelf2.addBook(validBook3);
       validStore2.addShelf(validShelf2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMaxNumberOfShelves method, of class BookStore.
     */
    @Test
    public void testGetMaxNumberOfShelves() {
        System.out.println("getMaxNumberOfShelves");
        BookStore instance = validStore;
        int expResult = 4;
        int result = instance.getMaxNumberOfShelves();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalBooksInStore method, of class BookStore.
     */
    @Test
    public void testGetTotalBooksInStore() {
        System.out.println("getTotalBooksInStore");
        BookStore instance = validStore;
        int expResult = 0;
        int result = instance.getTotalBooksInStore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalNumberOfAuthors method, of class BookStore.
     */
    @Test
    public void testGetTotalNumberOfAuthors() {
        System.out.println("getTotalNumberOfAuthors");
        BookStore instance = validStore;
        int expResult = 0;
        int result = instance.getTotalNumberOfAuthors();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTotalNumberOfAuthors2() {
        System.out.println("getTotalNumberOfAuthors2");
        BookStore instance = validStore2;
        int expResult = 3;
        int result = instance.getTotalNumberOfAuthors();
        assertEquals(expResult, result);
    }

    /**
     * Test of addShelf method, of class BookStore.
     */
    @Test
    public void testAddShelf() {
        System.out.println("addShelf");
        BookShelf newShelf = null;
        BookStore instance = validStore;
        try {
            instance.addShelf(newShelf);
            fail("Should have thrown an exception");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testAddShelf3() {
        System.out.println("addShelf3");
        BookShelf newShelf = null;
        BookStore instance = new BookStore(1);
        instance.addShelf(validShelf1);
        try {
            instance.addShelf(newShelf);
            fail("Should have thrown an exception");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testConstructor() {
        System.out.println("constuctor");
        BookStore instance;
        try {
            instance = new BookStore(0);
            fail("Should have thrown an exception");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testAddShelf2() {
        System.out.println("addShelf2");
        BookShelf newShelf = validShelf1;
        BookStore instance = validStore;
        instance.addShelf(newShelf);
        ArrayList<BookShelf> expResult = new ArrayList<>();
        expResult.add(validShelf1);
        assertEquals(expResult, instance.getBookShelves());      
    }

     @Test
    public void testGetTotalBooksInStore2() {
        System.out.println("getTotalNumberOfBooks2");
        BookStore instance = validStore2;
        int expResult = 3;
        int result = instance.getTotalBooksInStore();
        assertEquals(expResult, result);
    }
}
