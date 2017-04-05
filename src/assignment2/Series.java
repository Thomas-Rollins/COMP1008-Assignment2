package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  TODO: change setArrayLists to add/remove methods
 * @author Thomas Rollins
 */
public class Series {

    private String seriesName;
    private ArrayList<Book> completedBooksInSeries, futureBooksInSeries;
    private enum STATUS {IN_PROGRESS, COMPLETED};
    private ArrayList<Author> authors;
    private LocalDate startDate, endDate;

    public Series(String seriesName) {
        this.seriesName = seriesName;
        
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public ArrayList<Book> getCompletedBooksInSeries() {
        return completedBooksInSeries;
    }

    public void setCompletedBooksInSeries(ArrayList<Book> completedBooksInSeries) {
        this.completedBooksInSeries = completedBooksInSeries;
    }

    public ArrayList<Book> getFutureBooksInSeries() {
        return futureBooksInSeries;
    }

    public void setFutureBooksInSeries(ArrayList<Book> futureBooksInSeries) {
        this.futureBooksInSeries = futureBooksInSeries;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    
}
