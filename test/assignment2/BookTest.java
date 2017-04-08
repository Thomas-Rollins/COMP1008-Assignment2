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
public class BookTest {
    private Book validBook;
    private Book validBook2;
    private Book validBook3;
    private Book validBook4;
    private Book validBook5;
    
    private Author validAuthor;
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
       validBook = new Book("Title", "978-92-95055-02-5", "Cover Artist", "Series1",
                LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
       validBook2 = new Book("Title", "978-92-95055-02-5", "Cover Artist", "Series1",
                LocalDate.of(2007, Month.JANUARY, 1), 19.99, 100, 50);
       validBook3 = new Book("Title", "978-92-95-02-5", "Cover Artist", "Series2",
                LocalDate.of(2006, Month.DECEMBER, 31), 19.99, 100, 50);
       validBook4 = new Book("Title", "978-92-95-02-5", "Cover Artist", "Series3",
                null, 19.99, 100, 50);
       validBook5 = new Book("Title", "978-92-95951-02-5", "Cover Artist", null,
               LocalDate.of(2018, Month.DECEMBER, 31), 19.99, 100, 50);
       
       validBook2.addGenres("FANTASY");
       validBook2.addGenres("ADVENTURE");
       
       validAuthor = new Author("Thomas", "Rollins", "Canadian", LocalDate.of(1994,
               Month.NOVEMBER, 24));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = validBook;
        String expResult = "Title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title2";
        Book instance = validBook;
        instance.setTitle(title);
        assertEquals(title, validBook.getTitle());
    }

    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        Book instance = validBook;
        String expResult = "978-92-95055-02-5";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetIsbn2() {
        System.out.println("getIsbn - no publishdate");
        Book instance = validBook4;
        String expResult = null;
        String result = instance.getIsbn();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "978-92-95024-02-5";
        Book instance = validBook;
        instance.setIsbn(isbn);
        assertEquals(isbn, validBook.getIsbn());
    }
    
    @Test
    public void testValidateIsbn4() {
        System.out.println("setIsbn2");
        String isbn = "978-92-95-02-5";
        Book instance = validBook4;
        try {
            instance.setIsbn(isbn);
            fail("The ISBN should have Thrown an Exception");
        } catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testValidateIsbn3() {
        System.out.println("setIsbn");
        String isbn = "978-92-950244-02-5";
        Book instance = validBook3;
      try {
            instance.setIsbn(isbn);
            fail("The ISBN should have Thrown an Exception");
        } catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testValidateIsbn2() {
        System.out.println("setIsbn2");
        String isbn = "978-92-95-02-5";
        Book instance = validBook2;
        try {
            instance.setIsbn(isbn);
            fail("The ISBN should have Thrown an Exception");
        } catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testValidateISBN() {
        System.out.println("validateISBN");
        String isbn = "978-43-53534-343-5";
        Book instance = validBook;
        try {
        instance.setIsbn(isbn);
        fail("The ISBN should have thrown an Exception");
        } catch (IllegalArgumentException e){}
    }

    @Test
    public void testGetCoverArtist() {
        System.out.println("getCoverArtist");
        Book instance = validBook;
        String expResult = "Cover Artist";
        String result = instance.getCoverArtist();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCoverArtist() {
        System.out.println("setCoverArtist");
        String coverArtist = "Cover Artist1";
        Book instance = validBook;
        instance.setCoverArtist(coverArtist);
        assertEquals(coverArtist, validBook.getCoverArtist());
    }

    @Test
    public void testGetGenres() {
        System.out.println("getGenres");
        Book instance = validBook;
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = instance.getGenres();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddGenres() {
        System.out.println("setGenres");
        String expResult = "FANTASY";
        Book instance = validBook;
        instance.addGenres(expResult);
        assertEquals(expResult, instance.getListOfGenres());
    }
    
     @Test
    public void testAddGenres2() {
        System.out.println("setGenres");
        String expResult = "FANTASY";
        Book instance = validBook2;
        try {
            instance.addGenres(expResult);
            fail("should have thown an exception");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testListGenres() {
        System.out.println("ListGenres");
        String expResult = "[]";
        Book instance = validBook;
        instance.addGenres(expResult);
        assertEquals(expResult, instance.getListOfGenres());
    }
    
    @Test
    public void testListGenres2() {
        System.out.println("ListGenres2");
        String expResult = "FANTASY, ADVENTURE";
        Book instance = validBook2;
        assertEquals(expResult, instance.getListOfGenres());
    }
    
    

    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        Book instance = validBook;
        ArrayList<Author> expResult = new ArrayList<>();
        ArrayList<Author> result = instance.getAuthors();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddAuthors() {
        System.out.println("setAuthors");
        Author author = validAuthor;
        Book instance = validBook;
        instance.addAuthors(author);
        assertEquals(author, validBook.getAuthors().get(validBook.getAuthors().size()-1));
    }
    
    @Test
    public void testValidAuthor() {
        System.out.println("InvalidAuthor");
        Author author = validAuthor;
        Book instance = validBook;
        instance.addAuthors(author);
        try {
            instance.addAuthors(author);
            fail("should have thrown an exception");
        }
        catch(IllegalArgumentException e){}
    }

    @Test
    public void testGetSeries() {
        System.out.println("getSeries");
        Book instance = validBook;
        String expResult = "Series1";
        String result = instance.getSeries();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSeries() {
        System.out.println("addSeries");
        String expResult = "Series1";
        Book instance = validBook5;
        instance.setSeries(expResult);
        assertEquals(expResult, instance.getSeries());
    }


    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Book instance = validBook;
        double expResult = 19.99;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.00);
    }

    @Test
    public void testSetCost() {
        System.out.println("setCost");
        double cost = 29.99;
        Book instance = validBook;
        instance.setCost(cost);
        assertEquals(cost, validBook.getCost(), 0.00);
    }
    
    @Test
    public void testSetCost2() {
        System.out.println("setCost2");
        double cost = 0.00;
        Book instance = validBook;
        try {
            instance.setCost(cost);
            fail("Should have thrown IllegalArgumentException");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testSetCost3() {
        System.out.println("setCost2");
        double cost = -2.50;
        Book instance = validBook;
        try {
            instance.setCost(cost);
            fail("Should have thrown IllegalArgumentException");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testGetPublishDate() {
        System.out.println("getPublishDate");
        Book instance = validBook;
        LocalDate expResult = LocalDate.of(2007, Month.JANUARY, 2);
        LocalDate result = instance.getPublishDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPublishDate() {
        System.out.println("setPublsihDate");
        Book instance = validBook;
        LocalDate publishDate = LocalDate.of(2006, Month.JANUARY, 10);
        instance.setPublishDate(publishDate);
        assertEquals(publishDate, validBook.getPublishDate());
    }

    @Test
    public void testGetNumberInStock() {
        System.out.println("getNumberInStock");
        Book instance = validBook;
        int expResult = 100;
        int result = instance.getNumberInStock();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumberInStock() {
        System.out.println("setNumberInStock");
        int numberInStock = 0;
        Book instance = validBook;
        instance.setNumberInStock(numberInStock);
        assertEquals(numberInStock, validBook.getNumberInStock());
    }
    
    @Test
    public void testSetNumberInStock2() {
        System.out.println("setNumberInStock");
        int numberInStock = 10;
        Book instance = validBook;
        instance.setNumberInStock(numberInStock);
        assertEquals(numberInStock, validBook.getNumberInStock());
    }
    
    @Test
    public void testSetNumberInStock3() {
        System.out.println("setNumberInStock");
        int numberInStock = -1;
        Book instance = validBook;
        try {
            instance.setNumberInStock(numberInStock);
            fail("Should have Thrown an IllegalArgumentException");
        } catch(IllegalArgumentException e){}
    }

    @Test
    public void testGetSales() {
        System.out.println("getSales");
        Book instance = validBook;
        int expResult = 50;
        int result = instance.getSales();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSales() {
        System.out.println("setSales");
        int sales = 15;
        Book instance = validBook;
        instance.setSales(sales);
        assertEquals(sales, validBook.getSales());
    }
    
    @Test
    public void testSetSales2() {
        System.out.println("setSales2");
        int sales = 0;
        Book instance = validBook;
        instance.setSales(sales);
        assertEquals(sales, validBook.getSales());
    }
    
    @Test
    public void testSetSales3() {
        System.out.println("setSales");
        int sales = -1;
        Book instance = validBook;
        try {
            instance.setSales(sales);
            fail("Should have thrown an IllegalArgumentException");
        }
        catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testGetStatus() {
        System.out.println("setStatus");
        String expResult = "COMPLETED";
        Book instance = validBook;
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetStatus2() {
        System.out.println("setStatus2");
        String expResult = "IN_PROGRESS";
        Book instance = validBook5;
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
  
    
}
