package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Thomas Rollins
 */
public class Author {

    private String firstName, lastName, nationality;
    private ArrayList<Book> currentlyWritting, publishedBooks;
    private int numberOfBooksPublished; //change to derived local
    private LocalDate dateOfBirth;

    public Author(String firstName, String lastName, String nationality, LocalDate dateOfBirth) {
        
        setFirstName(firstName);
        setLastName(lastName);
        setNationality(nationality);
        setDateOfBirth(dateOfBirth);
        
    }

    /* START OF GETTERS/SETTERS */
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ArrayList<Book> getCurrentlyWritting() {
        return currentlyWritting;
    }

    public ArrayList<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public int getNumberOfBooksPublished() {
        return numberOfBooksPublished;
    }

    public void setNumberOfBooksPublished(int numberOfBooksPublished) {
        this.numberOfBooksPublished = numberOfBooksPublished;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /* END OF GETTERS/SETTERS */
    
}
