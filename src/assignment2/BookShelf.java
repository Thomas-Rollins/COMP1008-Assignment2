/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOKSHELF CLASS
 */
package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Thomas Rollins
 */
public class BookShelf {

    private final int MAX_BOOKS_PER_ROW;
    private final int MAX_SHELF_COLUMNS;
 
    private ArrayList<Book>[] shelf;
    
    /**
     * constructor for the BookShelf class
     * @param maxNumberOfRows
     * @param maxNumberOfColumns 
     */
    public BookShelf(int maxNumberOfRows, int maxNumberOfColumns)
    {
        if(validateMaxBooksPerRow(maxNumberOfRows))
            MAX_BOOKS_PER_ROW = maxNumberOfRows;
        else
            throw new IllegalArgumentException("Invalid number of rows");
        if(validateMaxNumberOfColumns(maxNumberOfColumns))
            MAX_SHELF_COLUMNS = maxNumberOfColumns;
        else
            throw new IllegalArgumentException("Invalid number of Columns");
        //int the Array
        shelf = new ArrayList[MAX_SHELF_COLUMNS];
        
        //int the ArrayLists
        for(int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            shelf[i] = new ArrayList<>();
        }
    }
    
    /* START OF GETTERS/SETTERS */
    /**
     * gets the maxRows
     * @return 
     */
    public int getMaxRows()
    {
       return MAX_BOOKS_PER_ROW;
    }
    
    /**
     * gets the Max Columns
     * @return 
     */
    public int getMaxColumns()
    {
        return MAX_SHELF_COLUMNS;
    }
    
    /**
     * gets the totalCapacity
     * @return 
     */
    public int getTotalCapacity()
    {
        return MAX_BOOKS_PER_ROW * MAX_SHELF_COLUMNS;
    }
    
    /**
     * adds a Book to the shelf
     * @param book 
     */
    public void addBook(Book book)
    {
        for(int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
             if(validateAddBook(i))
             {
                shelf[i].add(book);
                return;
             } 
        }
        throw new IllegalArgumentException("The BookShelf is completely Full");
    }

    /**
     * gets all Books on the shelf as a list
     * @return 
     */
    public ArrayList getAllBooksOnShelf()
    {
        ArrayList<Book> allBooksOnShelf = new ArrayList<>();
        for (int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            for (int index = 0; index < shelf[i].size(); index++)
            {
                allBooksOnShelf.add(shelf[i].get(index));
            }
        }
        
        return allBooksOnShelf;
    }

    /**
     * gets the number of Books on the shelf
     * @return 
     */
    public int getNumberOfBooksOnShelf()
    {
        int numberOfBooksOnShelf = getAllBooksOnShelf().size();
        
        return numberOfBooksOnShelf;
    }
    
    /**
     * gets the list of authors on the shelf
     * @return 
     */
    public ArrayList<String> getAuthorsOnShelf()
    {
        ArrayList<String> authorsOnShelf = new ArrayList<>();
        for(int index = 0; index < shelf.length; index++)
        {
            for (int i = 0; i < shelf[index].size(); i++)
            {
                for (int j = 0; j < shelf[index].get(i).getAuthors().size(); j++)
                {
                    if(!authorsOnShelf.contains(shelf[index].get(i).getAuthors().get(j)) 
                            && shelf[index].get(i).getAuthors().get(j) != "No Author")
                    authorsOnShelf.add(shelf[index].get(i).getAuthors().get(j));
                } 
            }
        }
        
        //sort by last name
       Collections.sort(authorsOnShelf);
        
        return authorsOnShelf;
    }
    
    /**
     * gets the range of authors (by last name) from the shelf
     * @return 
     */
    public String getAuthorListRangeOnShelf()
    {
        String output = "";
        ArrayList<String> authorsOnShelf = new ArrayList<>();
        
        for(String authors1: getAuthorsOnShelf())
        {
            authorsOnShelf.add(authors1.substring(authors1.lastIndexOf(" ")+1));
        }
                
        switch (authorsOnShelf.size()) {
            case 1:
                output = authorsOnShelf.get(0);
                break;
            case 0:
                output = "No Authors Listed";
                break;
            default:
                output = authorsOnShelf.get(0) + " - " + authorsOnShelf.get(authorsOnShelf.size()-1);
                break;
        }
        return output;
    }
    
    /**
     * gets the number of Authors on the Shelf
     * @return 
     */
    public int getNumberOfAuthorsOnShelf()
    {
        ArrayList<String> authorList = new ArrayList<>();
        for (int i = 0; i < MAX_SHELF_COLUMNS; i ++)
        {
           for (int j = 0; j < getAuthorsOnShelf().size(); j++)
           {
               if(!authorList.contains(getAuthorsOnShelf().get(j)))
                   authorList.add(getAuthorsOnShelf().get(j));
           }
        }
        int numberOfAuthorsOnShelf = authorList.size();
        return numberOfAuthorsOnShelf;
    }
    
    /**
     * gets the genres on the shelf as a list
     * @return 
     */
    public ArrayList<String> getGenresOnShelf()
    {
        ArrayList<String> genresOnShelf = new ArrayList<>();
        for(int index = 0; index < shelf.length; index++)
        {
            for (int i = 0; i < shelf[index].size(); i++)
            {
                for (int j = 0; j < shelf[index].get(i).getGenres().size(); j++)
                {
                    if(!genresOnShelf.contains(shelf[index].get(i).getGenres().get(j))) 
                    {
                        genresOnShelf.add(shelf[index].get(i).getGenres().get(j));
                    } 
                }
            }
        }
         Collections.sort(genresOnShelf);
        return genresOnShelf;
    }
    
    /**
     * gets the first Genre (alphabetically) on the shelf
     * @return 
     */
    public String getShelfGenre()
    {
        String output = "";
             
        if (getGenresOnShelf().isEmpty())
                return "No Genre Listed";
        output = getGenresOnShelf().get(0);
        
        return output;
    }
    
    /* END OF GETTERS/SETTERS */
    
    /* START OF VALIDATORS */
    
    /**
     * validates maxBooksPerRow as > 0
     * @param maxNumberOfRows
     * @return 
     */
    private boolean validateMaxBooksPerRow(int maxNumberOfRows)
    {
        return (maxNumberOfRows > 0);
    }
    
    /**
     * validates the maxColumns as > 0
     * @param maxNumberOfColumns
     * @return 
     */
    private boolean validateMaxNumberOfColumns(int maxNumberOfColumns)
    {
        return (maxNumberOfColumns > 0);
    }
    
    /**
     * validates that there is enough space for the book on the shelf
     * @param row
     * @return 
     */
    private boolean validateAddBook(int row)
    {
        return (shelf[row].size() < MAX_BOOKS_PER_ROW);    
    }
    
    /* END OF VALIDTORS */
    
    /**
     * removes Book from the shelf
     * @param book 
     */
    public void removeBook(Book book)
    {
        for (int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            for (int index = 0; index < shelf[i].size(); index++)
            {
                shelf[i].remove(book);
            }
        }
    }

}
