/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOKSTORE CLASS
 */
package assignment2;

import java.util.ArrayList;

/**
 *
 * @author Thomas Rollins
 */
public class BookStore {

    private final int MAX_NUMBER_OF_SHELVES;
    private ArrayList<BookShelf> shelfList;
    
    /**
     * Constructor for the BookStore class
     * @param maxNumberOfShelves 
     */
    public BookStore(int maxNumberOfShelves)
    {
        if(validateMaxNumberOfShelves(maxNumberOfShelves))
            MAX_NUMBER_OF_SHELVES = maxNumberOfShelves;
        else
            throw new IllegalArgumentException("Number of Shelves must be greater than zero.");
        shelfList = new ArrayList<>();
    }
    
    /* START OF GETTERS/SETTERS */
    /**
     * gets max number of Shelves
     * @return 
     */
    public int getMaxNumberOfShelves()
    {
        return MAX_NUMBER_OF_SHELVES;
    }
    
    /**
     * gets the total Books in store
     * @return 
     */
    public int getTotalBooksInStore()
    {
        int totalNumberOfBooks = 0; //default
        for (BookShelf shelfList1 : shelfList) 
        {
            totalNumberOfBooks += shelfList1.getNumberOfBooksOnShelf();
        }
        return totalNumberOfBooks;
    }
    
    /**
     * gets the total number of Authors
     * @return 
     */
    public int getTotalNumberOfAuthors()
    {
        int totalNumberOfAuthors = 0; //default
        for (BookShelf shelfList1 : shelfList)
        {
            totalNumberOfAuthors += shelfList1.getNumberOfAuthorsOnShelf();
        }
        return totalNumberOfAuthors;
    }
    
    /**
     * gets all bookshelves as a list
     * @return 
     */
    public ArrayList<BookShelf> getBookShelves()
    {
        return shelfList;        
    }
    
    /* END OF GETTERS/SETTERS */
    
    /**
     * adds a bookshelf
     * @param newShelf 
     */
    public void addShelf(BookShelf newShelf)
    {
        if(validateAddShelves(newShelf))
            shelfList.add(newShelf);
        else
            throw new IllegalArgumentException("The store is full or the newShelf is null");
    }
    /* START OF VALIDATORS */
    
    /**
     * validates the max number of shelves
     * @param maxNumberOfShelves
     * @return 
     */
    private boolean validateMaxNumberOfShelves(int maxNumberOfShelves)
    {
        return maxNumberOfShelves > 0;
    }
    
    /**
     * validates there is enough space to add a new shelf
     * @param newShelf
     * @return 
     */
    private boolean validateAddShelves(BookShelf newShelf)
    {
        return (shelfList.size() < MAX_NUMBER_OF_SHELVES && newShelf != null);
    }
    
    /* END OF VALIDATORS */
}
