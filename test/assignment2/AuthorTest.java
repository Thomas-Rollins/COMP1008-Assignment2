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
public class AuthorTest {
    private Author validAuthor;
    
    public AuthorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        validAuthor = new Author("Valid", "Author", "Canadian", LocalDate.of(1084, Month.MARCH, 12));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class Author.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Author instance = validAuthor;
        String expResult = "Valid";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Author.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String expResult = "Brent";
        Author instance = validAuthor;
        instance.setFirstName(expResult);
        assertEquals(expResult, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class Author.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Author instance = validAuthor;
        String expResult = "Author";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Author.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String expResult = "Weeks";
        Author instance = validAuthor;
        instance.setLastName(expResult);
        assertEquals(expResult, instance.getLastName());
    }

    /**
     * Test of getNationality method, of class Author.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        Author instance = validAuthor;
        String expResult = "CANADIAN";
        String result = instance.getNationality();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNationality method, of class Author.
     */
    @Test
    public void testSetNationality() {
        System.out.println("setNationality");
        String expResult = "AMERICAN";
        Author instance = validAuthor;
        instance.setNationality(expResult);
        assertEquals(expResult, instance.getNationality());
    }

    /**
     * Test of getDateOfBirth method, of class Author.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        Author instance = validAuthor;
        LocalDate expResult = LocalDate.of(1084, Month.MARCH, 12);
        LocalDate result = instance.getDateOfBirth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateOfBirth method, of class Author.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        LocalDate expResult = LocalDate.of(1991, Month.MAY, 18);
        Author instance = validAuthor;
        instance.setDateOfBirth(expResult);
        assertEquals(expResult, instance.getDateOfBirth());
    }
    
}
