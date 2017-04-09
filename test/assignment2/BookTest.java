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
        
       validBook = new Book("Title", "Brent Weeks", "978-92-95055-02-5", "Cover Artist", "Series1",
                "publisher", LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
       validBook2 = new Book("Title", "", "978-92-95055-02-5", "Cover Artist", "Series1",
                "publisher", LocalDate.of(2007, Month.JANUARY, 1), 19.99, 100, 50);
       validBook3 = new Book("Title", "Brent Weeks, Author Two", "978-92-95-02-5", "Cover Artist", "Series2",
                "publisher", LocalDate.of(2006, Month.DECEMBER, 31), 19.99, 100, 50);
       validBook4 = new Book("Title", "Author Three", "978-92-95-02-5", "Cover Artist", "Series3",
                "publisher", null, 19.99, 100, 50);
       validBook5 = new Book("Title", "Author Three", "978-92-95951-02-5", "Cover Artist", null,
               "", LocalDate.of(2018, Month.DECEMBER, 31), 19.99, 100, 50);
       
       validBook.addGenres("FANTASY");
       validBook2.addGenres("FANTASY");
       validBook2.addGenres("ADVENTURE");
       
       
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
        assertEquals(title, instance.getTitle());
    }
    
    @Test
    public void testSetTitle2() {
        System.out.println("setTitle");
        String title = "";
        String expResult = "NO TITLE";
        Book instance = validBook;
        instance.setTitle(title);
        assertEquals(expResult, instance.getTitle());
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
        assertEquals(isbn, instance.getIsbn());
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
    public void testValidateIsbn5() {
        System.out.println("setIsbn2");
        String isbn = "";
        Book instance = validBook4;
        instance.setIsbn(isbn);
        assertEquals(isbn, instance.getIsbn());
           
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
        assertEquals(coverArtist, instance.getCoverArtist());
    }
    
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Book instance = validBook;
        String expResult = "publisher";
        String result = instance.getPublisher();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenres() {
        System.out.println("getGenres");
        Book instance = validBook;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("FANTASY");
        ArrayList<String> result = instance.getGenres();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddGenres() {
        System.out.println("setGenres");
        String expResult = "FANTASY";
        Book instance = validBook;
        //instance.addGenres(expResult);
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
        String expResult = "FANTASY";
        Book instance = validBook;
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
    public void testGetAuthorsList()
    {
        System.out.println("getAuthorsList");
        Book instance = validBook;
        String expResult = "Brent Weeks";
        assertEquals(expResult, instance.getAuthorsList());
    }
    
    @Test
    public void testGetAuthorsList2()
    {
        System.out.println("getAuthorsList2");
        Book instance = validBook3;
        String expResult = "Brent Weeks, Author Two";
        assertEquals(expResult, instance.getAuthorsList());
    }
    
     @Test
    public void testGetAuthorsList3()
    {
        System.out.println("getAuthorsList2");
        Book instance = validBook2;
        String expResult = "No Author";
        assertEquals(expResult, instance.getAuthorsList());
    }
    
    @Test
    public void testGetListOfGenres()
    {
        System.out.println("GetListOfGenres");
        Book instance = validBook;
        String expResult = "FANTASY";
        assertEquals(expResult, instance.getListOfGenres());
    }
    
    @Test
    public void testGetListOfGenres2()
    {
        System.out.println("GetListOfGenres2");
        Book instance = validBook2;
        String expResult = "FANTASY, ADVENTURE";
        assertEquals(expResult, instance.getListOfGenres());
    }
    
    @Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        Book instance = validBook;
        try {
            instance.setAuthors("Brent Weeks");
            fail("Should have thrown an Exception");
            
        } catch(IllegalArgumentException e){}
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
        assertEquals(cost, instance.getCost(), 0.00);
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
        assertEquals(publishDate, instance.getPublishDate());
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
        assertEquals(numberInStock, instance.getNumberInStock());
    }
    
    @Test
    public void testSetNumberInStock2() {
        System.out.println("setNumberInStock");
        int numberInStock = 10;
        Book instance = validBook;
        instance.setNumberInStock(numberInStock);
        assertEquals(numberInStock, instance.getNumberInStock());
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
        assertEquals(sales, instance.getSales());
    }
    
    @Test
    public void testSetSales2() {
        System.out.println("setSales2");
        int sales = 0;
        Book instance = validBook;
        instance.setSales(sales);
        assertEquals(sales, instance.getSales());
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
}
