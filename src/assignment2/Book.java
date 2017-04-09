/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOK CLASS
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  Book Class
 * @author Thomas Rollins
 */
public class Book {
    
    private String title, isbn, coverArtist;
    private ArrayList<String> genres;
    private ArrayList<String> authors;
    private String series, publisher;
    private double cost;
    private int numberInStock, sales;
    private LocalDate publishDate;
    
    /**
     * constructor for Book class
     * 
     * @param title
     * @param authors
     * @param isbn
     * @param coverArtist
     * @param series
     * @param publisher
     * @param publishDate
     * @param cost
     * @param numberInStock
     * @param sales 
     */
    public Book(String title, String authors, String isbn, String coverArtist, String series, String publisher, LocalDate publishDate,
            double cost, int numberInStock, int sales) {
        
        setPublishDate(publishDate);
        setTitle(title);
        //sets ISBN as null if publishDate is null
        if(this.getPublishDate()!= null)
            setIsbn(isbn);
        else
            this.isbn = null;
        
        //int ArrayLists
        genres = new ArrayList<>();
        this.authors = new ArrayList<>();
        
        //finish Assignment
        setAuthors(authors);
        setCoverArtist(coverArtist);
        setSeries(series);
        setCost(cost);
        setNumberInStock(numberInStock);
        setSales(sales);
        setPublisher(publisher);
    }
    
    /* START OF VALIDATORS */
    
    /*
     * **** Assuming the following groups are always valid ****
     * The first 3 are the EAN (always 3)
     * The next 1-5 are the Registration Group
     * The next 1-7 are the Registrant
     * The next 1-6 are the Publication 
     * The last digit is the check number (always 1)
     * For a total of 13 Digits
     * ************************************************
    */
    /**
     * validates the ISBN based on the following criteria:
     * Prior to 2007--> xxxxxxxxxx (always a total of 10)
     * After 2007 JAN 1st --> xxxxxxxxxxxxx
     * Always a  total of 13 characters (ignoring dashes)
     * book must have an exact publish date to have an ISBN
     * @param isbn
     * @return 
     */
    private boolean validateISBN(String isbn)
    {
        String concatISBN = isbn.replace("-", ""); //removes dashes "-"
        
        if(concatISBN.equals(""))
            return true;
        if (this.getPublishDate()!= null)
        {
            if(this.getPublishDate().isBefore(LocalDate.of(2007, Month.JANUARY, 1)) &&
                    (concatISBN.length() == 10))
            {
                String patternMatch = ("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
                if (concatISBN.matches(patternMatch))
                {
                    return true;
                }
            }
            else if(concatISBN.length() == 13) //may have been converted to 13digit
            {
                String patternMatch = ("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
                if (concatISBN.matches(patternMatch))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Validates the cost to be >= 0
     * @param cost
     * @return 
     */
    private boolean validateCost(double cost)
    {
        return cost >= 0.00;
    }
    
    /**
     * validates the sales to be >= 0
     * @param sales
     * @return 
     */
    private boolean validateSales(int sales)
    {
        return sales >= 0;
    }
    
    /**
     * validates the number in stock to be >= 0
     * @param numberInStock
     * @return 
     */
    private boolean validateNumberInStock(int numberInStock)
    {
        return numberInStock >= 0;
    }
    
    /**
     * validates the Genres to ensure a single book cannot have duplicates
     * @param genre
     * @return 
     */
    private boolean validateGenres(String genre)
    {
       return !genres.contains(genre);
    }
    
    /**
     * validates the author to ensure a single book cannot have duplicates
     * @param author
     * @return 
     */
    private boolean validateAuthor(String author)
    {
        return !authors.contains(author);
    }
    
    /* END OF VALIDATORS */
    

    /* START OF GET/SETTERS */
    
    /**
     * gets the title
     * @return 
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title
     * @param title 
     */
    public void setTitle(String title) {
        if(title.trim().equals(""))
            title = "NO TITLE";
        this.title = title;
    }

    /**
     * gets the ISBN
     * @return 
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * sets the ISBN
     * @param isbn 
     */
    public void setIsbn(String isbn) {
        if(validateISBN(isbn))
            this.isbn = isbn;
        else
            throw new IllegalArgumentException("invalid ISBN");
    }

    /**
     * gets the coverArtist
     * @return 
     */
    public String getCoverArtist() {
        return coverArtist;
    }

    /**
     * sets the coverArtist
     * @param coverArtist 
     */
    public void setCoverArtist(String coverArtist) {
        this.coverArtist = coverArtist;
    }

    /**
     * gets the list of genres
     * @return 
     */
    public ArrayList<String> getGenres() {
        return genres;
    }
    
    /**
     * gets the list of genres as a single String
     * @return 
     */
    public String getListOfGenres()
    {
        String output = "";
       if(genres.size() == 1)
                {
                    return genres.get(0);
                }
        for(int i = 0; i < genres.size() - 1; i++)
            {
                output += genres.get(i) + ", ";
            }
            output += genres.get(genres.size() - 1);

            
        return output;
    }

    /**
     * gets the list of authors
     * @return 
     */
    public ArrayList<String> getAuthors() {
        return authors;
    }
    
    /**
     * sets the Authors
     * @param authorsString 
     */
    public void setAuthors(String authorsString)
    {
        if(authorsString == "")
        {
            authors.add("No Author");
            return;
        }
        String[] authorList;
        authorList = authorsString.split("\\s*,\\s*");
        
        for (String authorList1 : authorList) {
            if (validateAuthor(authorList1)) {
                authors.add(authorList1);
            } else {
                throw new IllegalArgumentException("Cannot add Duplicates");
            }
        }
    }
    
    /**
     * gets the authors as a single String
     * @return 
     */
    public String getAuthorsList() 
    {
        String output = "";
        if(authors.size() == 1) {
            return authors.get(0);
        }
        for(int i = 0; i < authors.size() - 1; i++)
        {
            output += authors.get(i) + ", ";
        }
        output += authors.get(authors.size() - 1);
        
        return output;
    }

    /**
     * gets the series
     * @return 
     */
    public String getSeries() {
        return series;
    }

    /**
     * sets the series
     * @param series 
     */
    public void setSeries(String series) {
        this.series = series;
    }
    
    /**
     * gets the PublishDate
     * @return 
     */
    public LocalDate getPublishDate()
    {
        return this.publishDate;
    }
    
    /**
     * sets the publish date
     * @param publishDate 
     */
    public void setPublishDate(LocalDate publishDate)
    {
        this.publishDate = publishDate;
    }
    
    /**
     * sets the publisher
     * @param publisher 
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    /**
     * gets the publisher
     * @return 
     */
    public String getPublisher()
    {
        return publisher;
    }
 
    /**
     * gets the cost
     * @return 
     */
    public double getCost() {
        return cost;
    }

    /**
     * sets the cost
     * @param cost 
     */
    public void setCost(double cost) {
        if(validateCost(cost))
            this.cost = cost;
        else
            throw new IllegalArgumentException("The cost must be Greater than 0.00");
    }

    /**
     * gets the NumberInStock
     * @return 
     */
    public int getNumberInStock() {
        return numberInStock;
    }

    /**
     * returns the number in stock
     * @param numberInStock 
     */
    public void setNumberInStock(int numberInStock) {
        if(validateNumberInStock(numberInStock))
            this.numberInStock = numberInStock;
        else
            throw new IllegalArgumentException("The number in stock must be a postive"
                    + "integer");
    }

    /**
     * gets the sales
     * @return 
     */
    public int getSales() {
        return sales;
    }

    /**
     * sets the number of sales
     * @param sales 
     */
    public void setSales(int sales) {
        if(validateSales(sales))
            this.sales = sales;
        else
            throw new IllegalArgumentException("The sales must be a postive"
                    + "integer");
    }

    /* END OF SET/GETTERS */
    
    /**
     * adds a genre to the list
     * @param genre 
     */
    public void addGenres(String genre)
    {
        String[] genrelist;
        genre = genre.toUpperCase();
        genrelist = genre.split("\\s*,\\s*");
        
        for (String genrelist1 : genrelist) {
            if (validateGenres(genrelist1)) {
                genres.add(genrelist1);
            } else {
                throw new IllegalArgumentException("Cannot add Duplicates");
            }
        }
    }
}
