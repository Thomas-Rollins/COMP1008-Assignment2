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
public class BookShelfTest {
    private BookShelf validShelf1;
    private Book validBook;
    private Book validBook2;
    private Book validBook3;
    private Book validBook4;
    private Book validBook5;
    
    private Series validSeries, validSeries2;
    
    
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
        validShelf1 = new BookShelf(10, 5);
        
        validSeries = new Series("Valid-Series");
        validSeries2 = new Series("ValdSeries2");
        
        validBook = new Book("Title", "978-92-95055-02-5", "Cover Artist", validSeries,
                LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
        validBook2 = new Book("Title", "978-92-95055-02-5", "Cover Artist", validSeries,
                LocalDate.of(2007, Month.JANUARY, 1), 19.99, 100, 50);
        validBook3 = new Book("Title", "978-92-95-02-5", "Cover Artist", validSeries,
                LocalDate.of(2006, Month.DECEMBER, 31), 19.99, 100, 50);
        validBook4 = new Book("Title", "978-92-95-02-5", "Cover Artist", validSeries,
                null, 19.99, 100, 50);
        validBook5 = new Book("Title", "978-92-95951-02-5", "Cover Artist", null,
               LocalDate.of(2018, Month.DECEMBER, 31), 19.99, 100, 50);
        
        validShelf1.addBook(0, validBook);
        validShelf1.addBook(0, validBook2);
        validShelf1.addBook(1, validBook3);
        validShelf1.addBook(1, validBook4);
        validShelf1.addBook(1, validBook5);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetMaxRows() {
        System.out.println("getMaxRows");
        BookShelf instance = validShelf1;
        int expResult = 10;
        int result = instance.getMaxRows();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxColumns() {
        System.out.println("getMaxColumns");
        BookShelf instance = validShelf1;
        int expResult = 5;
        int result = instance.getMaxColumns();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBooksOnShelfRow() {
        System.out.println("getBooksOnShelfRow");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList expResult = null;
        ArrayList result = instance.getBooksOnShelfRow(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllBooksOnShelf() {
        System.out.println("getAllBooksOnShelf");
        BookShelf instance = validShelf1;
        ArrayList expResult = null;
        ArrayList result = instance.getAllBooksOnShelf();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAuthorsOnShelf() {
        System.out.println("getAuthorsOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList<Author> expResult = null;
        ArrayList<Author> result = instance.getAuthorsOnShelf(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListOfAuthorsOnShelf() {
        System.out.println("getListOfAuthorsOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        String expResult = "";
        String result = instance.getListOfAuthorsOnShelf(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetGenresOnShelf() {
        System.out.println("getGenresOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getGenresOnShelf(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListOfGenresOnShelf() {
        System.out.println("getListOfGenresOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        String expResult = "";
        String result = instance.getListOfGenresOnShelf(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
