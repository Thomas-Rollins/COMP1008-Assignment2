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
    private BookShelf validShelf1, validShelf2;
    private Book validBook;
    private Book validBook2;
    private Book validBook3;
    private Book validBook4;
    private Book validBook5;
    
    private Author validAuthor, validAuthor2, validAuthor3;
    
    
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
        
        validBook = new Book("Title", "978-92-95055-02-5", "Cover Artist", "Series2",
                LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
        validBook2 = new Book("Title", "978-92-95055-02-5", "Cover Artist", "Series1",
                LocalDate.of(2007, Month.JANUARY, 1), 19.99, 100, 50);
        validBook3 = new Book("Title", "978-92-95-02-5", "Cover Artist", "Series3",
                LocalDate.of(2006, Month.DECEMBER, 31), 19.99, 100, 50);
        validBook4 = new Book("Title", "978-92-95-02-5", "Cover Artist", "Series1",
                null, 19.99, 100, 50);
        validBook5 = new Book("Title", "978-92-95951-02-5", "Cover Artist", null,
               LocalDate.of(2018, Month.DECEMBER, 31), 19.99, 100, 50);
        
        validShelf1.addBook(0, validBook);
        validBook.addGenres("fantasy");
        validShelf1.addBook(0, validBook2);
        validBook2.addGenres("adventure");
        validShelf1.addBook(1, validBook3);
        validShelf1.addBook(1, validBook4);
        validBook4.addGenres("Romance");
        validShelf1.addBook(1, validBook5);
        
        validAuthor = new Author("Thomas", "Rollins", "Canadian", LocalDate.of(1994,
               Month.NOVEMBER, 24));
        
        validAuthor2 = new Author("Tom", "Coulter", "Canadian", LocalDate.of(1992,
               Month.MARCH, 13));
        validAuthor3 = new Author("Tom", "Ehsani", "Canadian", LocalDate.of(1992,
               Month.MARCH, 13));
        
        validBook.addAuthors(validAuthor);
        validBook.addAuthors(validAuthor2);
        validBook2.addAuthors(validAuthor3);
        validBook3.addAuthors(validAuthor);
        
        
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
    public void testGetBooksOnShelfRow() {
        System.out.println("getBooksOnShelfRow");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList expResult = new ArrayList<>();
        expResult.add(validBook);
        expResult.add(validBook2);
        ArrayList result = instance.getBooksOnShelfRow(index);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetBooksOnShelfRow2() {
        System.out.println("getBooksOnShelfRow");
        int index = 1;
        BookShelf instance = validShelf1;
        ArrayList expResult = new ArrayList<>();
        expResult.add(validBook3);
        expResult.add(validBook4);
        expResult.add(validBook5);
        ArrayList result = instance.getBooksOnShelfRow(index);
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
    public void testGetAuthorsOnShelf() {
        System.out.println("getAuthorsOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList<Author> expResult = new ArrayList<>();
        expResult.add(validAuthor3);
        expResult.add(validAuthor);
        expResult.add(validAuthor2);
        Collections.sort(expResult, Comparator.comparing(Author::getLastName));
        ArrayList<Author> result = instance.getAuthorsOnShelf(index);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetListOfAuthorsOnShelf2() {
        System.out.println("getListOfAuthorsOnShelf2");
        int index = 1;
        BookShelf instance = validShelf2;
        String expResult = "";
        String result = instance.getListOfAuthorsOnShelf(index);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAuthorsOnShelf2() {
        System.out.println("getAuthorsOnShelf2");
        int index = 1;
        BookShelf instance = validShelf1;
        ArrayList<Author> expResult = new ArrayList<>();
        expResult.add(validAuthor);
        ArrayList<Author> result = instance.getAuthorsOnShelf(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetListOfAuthorsOnShelf() {
        System.out.println("getListOfAuthorsOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        String expResult = "Tom Coulter, Tom Ehsani, Thomas Rollins";
        String result = instance.getListOfAuthorsOnShelf(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenresOnShelf() {
        System.out.println("getGenresOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("FANTASY");
        expResult.add("ADVENTURE");
        ArrayList<String> result = instance.getGenresOnShelf(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetListOfGenresOnShelf() {
        System.out.println("getListOfGenresOnShelf");
        int index = 0;
        BookShelf instance = validShelf1;
        String expResult = "FANTASY, ADVENTURE";
        String result = instance.getListOfGenresOnShelf(index);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddBook() {
        System.out.println("testAddBook");
        int row = 0;
        BookShelf instance = validShelf1;
        instance.addBook(row, validBook);
        instance.addBook(row, validBook);
        instance.addBook(row, validBook);
        
        try {
            instance.addBook(row, validBook);
            fail("Should have thrown an Exception");
        }
        catch(IllegalArgumentException e){}
    }
    
}
