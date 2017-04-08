package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * TODO: sort lists
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
        //int the Array
        shelf = new ArrayList[MAX_SHELF_COLUMNS];
        
        //int the ArrayLists
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
    
    public int getTotalCapacity()
    {
        return MAX_BOOKS_PER_ROW * MAX_SHELF_COLUMNS;
    }
    
    
    public void addBook(int row, Book book)
    {
        if(validateAddBook(row))
            shelf[row].add(book);
        else
            throw new IllegalArgumentException("The row is completely filled");
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
    
    public ArrayList<Book> getAllBooksByAuthorOnShelf(Author author)
    {
        ArrayList<Book> allBooksOnShelfByAuthor = new ArrayList<>();
        for (int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            for (int index = 0; index < shelf[i].size(); index++)
            {
                if((shelf[i].get(index).getAuthors().contains(author)) && (!allBooksOnShelfByAuthor.contains((shelf[i].get(index)))))
                    allBooksOnShelfByAuthor.add(shelf[i].get(index));
                else {}
            }
        }
        
        return allBooksOnShelfByAuthor;
    }
    
    public int getNumberOfBooksOnShelf()
    {
        int numberOfBooksOnShelf = getAllBooksOnShelf().size();
        
        return numberOfBooksOnShelf;
    }
    
    public ArrayList<Author> getAuthorsOnShelf(int index)
    {
        ArrayList<Author> authorsOnShelf = new ArrayList<>();
        for (int i = 0; i < shelf[index].size(); i++)
        {
            for (int j = 0; j < shelf[index].get(i).getAuthors().size(); j++)
            {
                if(!authorsOnShelf.contains(shelf[index].get(i).getAuthors().get(j)))
                authorsOnShelf.add(shelf[index].get(i).getAuthors().get(j));
            }
            
        }
        //sort by last name
       Collections.sort(authorsOnShelf, Comparator.comparing(Author::getLastName));
        
        return authorsOnShelf;
    }
    
    public String getListOfAuthorsOnShelf(int index)
    {
        String output = "";
        ArrayList<Author> authorsOnShelf = getAuthorsOnShelf(index);
        
        while (!authorsOnShelf.isEmpty())
        {
            if(authorsOnShelf.size()==1)
            {
                output += authorsOnShelf.get(0).getFirstName() + " " + 
                    authorsOnShelf.get(0).getLastName();
                return output;
            }
            output += authorsOnShelf.get(0).getFirstName() + " " + 
                    authorsOnShelf.get(0).getLastName() + ", ";
            authorsOnShelf.remove(0);
        }
        return output;
    }
    
    public String getAuthorListRangeOnShelf()
    {
        String output = "";
        ArrayList<Author> authorsOnShelf = new ArrayList<>();
        ArrayList<Book> allBooksOnShelfByAuthor = new ArrayList<>();
        for (int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            for (int index = 0; index < shelf[i].size(); index++)
            {
                authorsOnShelf = getAuthorsOnShelf(index);
            }
        }
        
        switch (authorsOnShelf.size()) {
            case 1:
                output = authorsOnShelf.get(0).getLastName();
                break;
            case 0:
                output = "No Authors Listed";
                break;
            default:
                output = authorsOnShelf.get(0).getLastName() + " - " + authorsOnShelf.get(authorsOnShelf.size()-1).getLastName();
                break;
        }
            
        
        return output;
    }
    
    public int getNumberOfAuthorsOnShelf()
    {
        ArrayList<Author> authorList = new ArrayList<>();
        for (int i = 0; i < MAX_SHELF_COLUMNS; i ++)
        {
           for (int j = 0; j < getAuthorsOnShelf(i).size(); j++)
           {
               if(!authorList.contains(getAuthorsOnShelf(i).get(j)))
                   authorList.add(getAuthorsOnShelf(i).get(j));
           }
        }
        int numberOfAuthorsOnShelf = authorList.size();
        return numberOfAuthorsOnShelf;
    }
    
    public ArrayList<String> getGenresOnShelf(int index)
    {
        ArrayList<String> genresOnShelf = new ArrayList<>();
        for (int i = 0; i < shelf[index].size(); i++)
        {
            for (int j = 0; j < shelf[index].get(i).getGenres().size(); j++)
            {
                if(!genresOnShelf.contains(shelf[index].get(i).getGenres().get(j))) {
                    genresOnShelf.add(shelf[index].get(i).getGenres().get(j));
                } 
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
    
    public String getShelfGenre()
    {
        ArrayList<String> allGenresOnShelf = new ArrayList<>();
        String output = "";
        for (int i = 0; i < MAX_SHELF_COLUMNS; i++)
        {
            for (int index = 0; index < shelf[i].size(); index++)
            {
                allGenresOnShelf = getGenresOnShelf(index);
            }
        }
        if (allGenresOnShelf.isEmpty())
                return "No Genre Listed";
        output = allGenresOnShelf.get(0);
        
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
    
    private boolean validateAddBook(int row)
    {
        return (shelf[row].size() < MAX_BOOKS_PER_ROW);    
    }
    
    /* END OF VALIDTORS */
}
