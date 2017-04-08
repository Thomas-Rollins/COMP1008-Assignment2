package assignment2;

import java.util.ArrayList;

/**
 *
 * @author Thomas Rollins
 */
public class BookStore {

    private final int MAX_NUMBER_OF_SHELVES;
    private ArrayList<BookShelf> shelfList;
    
    public BookStore(int maxNumberOfShelves)
    {
        if(validateMaxNumberOfShelves(maxNumberOfShelves))
            MAX_NUMBER_OF_SHELVES = maxNumberOfShelves;
        else
            throw new IllegalArgumentException("Number of Shelves must be greater than zero.");
        shelfList = new ArrayList<>();
    }
    
    /* START OF GETTERS/SETTERS */
    
    public int getMaxNumberOfShelves()
    {
        return MAX_NUMBER_OF_SHELVES;
    }
    
    public int getTotalBooksInStore()
    {
        int totalNumberOfBooks = 0; //default
        for (BookShelf shelfList1 : shelfList) 
        {
            totalNumberOfBooks += shelfList1.getNumberOfBooksOnShelf();
        }
        return totalNumberOfBooks;
    }
    
    public int getTotalNumberOfAuthors()
    {
        int totalNumberOfAuthors = 0; //default
        for (BookShelf shelfList1 : shelfList)
        {
            totalNumberOfAuthors += shelfList1.getNumberOfAuthorsOnShelf();
        }
        return totalNumberOfAuthors;
    }
    
    public ArrayList<Book> getBooksInStoreByAuthor(Author author)
    {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (BookShelf shelfList1 : shelfList)
        {
            for(Book authorBook : shelfList1.getAllBooksByAuthorOnShelf(author))
            {
                if(!booksByAuthor.contains(authorBook))
                {
                    booksByAuthor.add(authorBook);
                }
            }
        }
        return booksByAuthor;
    }
    
    public ArrayList<BookShelf> getBookShelves()
    {
        return shelfList;        
    }
    
    /* END OF GETTERS/SETTERS */
    
    public void addShelf(BookShelf newShelf)
    {
        if(validateAddShelves(newShelf))
            shelfList.add(newShelf);
        else
            throw new IllegalArgumentException("The store is full or the newShelf is null");
    }
    /* START OF VALIDATORS */
    
    private boolean validateMaxNumberOfShelves(int maxNumberOfShelves)
    {
        return maxNumberOfShelves > 0;
    }
    
    private boolean validateAddShelves(BookShelf newShelf)
    {
        return (shelfList.size() < MAX_NUMBER_OF_SHELVES && newShelf != null);
    }
    
    /* END OF VALIDATORS */
    
}
