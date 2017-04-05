package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *  TODO: REMOVE series variable from constructor
 * @author Thomas Rollins
 */
public class Book {
    
    private String title, isbn, coverArtist;
    private ArrayList<String> genres;
    private ArrayList<Author> authors;
    private Series series;
    private double cost;
    private int numberInStock, sales;
    private enum STATUS {COMPLETED, IN_PROGRESS};
    private LocalDate publishDate;
    private STATUS bookStatus;
    public Book(String title, String isbn, String coverArtist, Series series, LocalDate publishDate,
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
        authors = new ArrayList<>();
        
        //finish Assignment
        setCoverArtist(coverArtist);
        setSeries(series);
        setCost(cost);
        setNumberInStock(numberInStock);
        setSales(sales);
        setStatus(); // dependant on publishdate
        
  
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
     * Always a  total of 13 characters 
     * book must have an exact publsih date to have an ISBN
     * @param isbn
     * @return 
     */
    private boolean validateISBN(String isbn)
    {
        String concatISBN = isbn.replace("-", ""); //removes dashes "-"
        
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
    
    private boolean validateCost(double cost)
    {
        return cost > 0.00;
    }
    
    private boolean validateSales(int sales)
    {
        return sales >= 0;
    }
    
    private boolean validateNumberInStock(int numberInStock)
    {
        return numberInStock >= 0;
    }
    
    private boolean validateGenres(String genre)
    {
       return !genres.contains(genre);
    }
    
    private boolean validateAuthor(Author author)
    {
        return !authors.contains(author);
    }
    
    private boolean validateSetSeries(Series series)
    {
        if(this.series == null)
            return true;
        else
            return false;
    }
    
    /* END OF VALIDATORS */
    

    /* START OF GET/SETTERS */
    
    private void setStatus()
    {
        if((publishDate == null) || (publishDate.isAfter(LocalDate.now())))
            setInProgress();
        else
            setCompleted();
    }
    
    public String getStatus()
    {
        return this.bookStatus.toString();
    }
    
    private void setCompleted()
    {
        bookStatus = STATUS.COMPLETED;
    }
    
    private void setInProgress()
    {
        bookStatus = STATUS.IN_PROGRESS;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(validateISBN(isbn))
            this.isbn = isbn;
        else
            throw new IllegalArgumentException("invalid ISBN");
    }

    public String getCoverArtist() {
        return coverArtist;
    }

    public void setCoverArtist(String coverArtist) {
        this.coverArtist = coverArtist;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
    
    public String getListOfGenres()
    {
        String output = "";
        for(int i = 0; i < genres.size() - 1; i++)
        {
            output += genres.get(i) + ", ";
        }
        output += genres.get(genres.size() - 1);
        return output;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        if(validateSetSeries(series))
            this.series = series;
        else
            throw new IllegalArgumentException("Invalid Series");
    }
    
    public LocalDate getPublishDate()
    {
        return this.publishDate;
    }
    
    public void setPublishDate(LocalDate publishDate)
    {
        this.publishDate = publishDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if(validateCost(cost))
            this.cost = cost;
        else
            throw new IllegalArgumentException("The cost must be Greater than 0.00");
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        if(validateNumberInStock(numberInStock))
            this.numberInStock = numberInStock;
        else
            throw new IllegalArgumentException("The number in stock must be a postive"
                    + "integer");
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        if(validateSales(sales))
            this.sales = sales;
        else
            throw new IllegalArgumentException("The sales must be a postive"
                    + "integer");
    }

    /* END OF SET/GETTERS */
    
    public void addGenres(String genre)
    {
        genre = genre.toUpperCase();
        if(validateGenres(genre))
            genres.add(genre);
        else
            throw new IllegalArgumentException("Cannot add duplicates");
    }
    
    public void addAuthors(Author author)
    {
        if(validateAuthor(author))
            authors.add(author);
        else
            throw new IllegalArgumentException("Invalid Author --> cannot add duplicates");   
    }
}
