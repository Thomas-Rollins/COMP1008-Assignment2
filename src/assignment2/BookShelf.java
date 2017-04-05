package assignment2;

import java.util.ArrayList;

/**
 *
 * @author Thomas Rollins
 */
public class BookShelf {

    private final int MAX_BOOKS_PER_ROW;
    private final int MAX_SHELF_COLUMNS;
 
    private ArrayList<Book>[] shelf;
    
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
        
        shelf = new ArrayList[MAX_SHELF_COLUMNS];
        
        for(int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            shelf[i] = new ArrayList<>();
        }
    }
    
    /* START OF GETTERS/SETTERS */
    
    public int getMaxRows()
    {
       return MAX_BOOKS_PER_ROW;
    }
    
    public int getMaxColumns()
    {
        return MAX_SHELF_COLUMNS;
    }
    
    public void addBook(int col, Book book)
    {
        shelf.get(col).add(book);
    }
    
    public ArrayList getBooksOnShelfRow(int index)
    {
        ArrayList<Book> booksOnShelfRow = new ArrayList<>();
        for (int i = 0; i < shelf[index].size(); i++)
        {
            booksOnShelfRow.add(shelf[index].get(i));
        }
        return booksOnShelfRow;
    }
    
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
    
    public ArrayList<Author> getAuthorsOnShelf(int index)
    {
        ArrayList<Author> authorsOnShelf = new ArrayList<>();
        for (int i = 0; i < shelf[index].size(); i++)
        {
            for (int j = 0; j < shelf[index].get(i).getAuthors().size(); j++)
            {
                authorsOnShelf.add(shelf[index].get(i).getAuthors().get(j));
            }
            
        }
        return authorsOnShelf;
    }
    
    public String getListOfAuthorsOnShelf(int index)
    {
        String output = "";
        ArrayList<Author> authorsOnShelf = getAuthorsOnShelf(index);
        for (int i = 0; i < authorsOnShelf.size() -1; i++)
        {
            output += authorsOnShelf.get(i) + ", ";
        }
        output += authorsOnShelf.get(authorsOnShelf.size() - 1);
        
        return output;
    }
    
    public ArrayList<String> getGenresOnShelf(int index)
    {
        ArrayList<String> genresOnShelf = new ArrayList<>();
        for (int i = 0; i < shelf[index].size(); i++)
        {
            for (int j = 0; j < shelf[index].get(i).getGenres().size(); j++)
            {
                if(!genresOnShelf.contains(genresOnShelf.add(shelf[index].get(i).getGenres().get(j))))
                    genresOnShelf.add(shelf[index].get(i).getGenres().get(j));
            }
        }
        return genresOnShelf;
    }
    
    public String getListOfGenresOnShelf(int index)
    {
        String output = "";
        ArrayList<String> genresOnShelf = getGenresOnShelf(index);
        for (int i = 0; i < genresOnShelf.size() -1; i++)
        {
            output += genresOnShelf.get(i) + ", ";
        }
        output += genresOnShelf.get(genresOnShelf.size() - 1);
        
        return output;
    }
    
    /* END OF GETTERS/SETTERS */
    
    /* START OF VALIDATORS */
    
    private boolean validateMaxBooksPerRow(int maxNumberOfRows)
    {
        return (maxNumberOfRows > 0);
    }
    
    private boolean validateMaxNumberOfColumns(int maxNumberOfColumns)
    {
        return (maxNumberOfColumns > 0);
    }
    
    /* END OF VALIDTORS */
}
