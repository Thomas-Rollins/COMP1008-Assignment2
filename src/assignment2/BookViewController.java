package assignment2;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML BookViewController class
 *
 * @author Thomas Rollins
 */
public class BookViewController implements Initializable {

    
    @FXML private TextField titleTextField;
    @FXML private TextField authorTextField;
    @FXML private TextField genresTextField;
    @FXML private TextField publisherTextField;
    @FXML private DatePicker publishDateDatePicker;
    @FXML private TextField isbnTextField;
    @FXML private TextField numberInStockTextField;
    @FXML private TextField seriesTextField;
    @FXML private TextField coverArtistTextField;
    @FXML private TextField costTextField;
    @FXML private TextField numberOfSalesTextField;
    
    @FXML private TextArea outputTextArea;
    
    @FXML private DatePicker publishDatePicker;
    
    private Book selectedBook;
    
    @FXML private Button returnButton;
    @FXML private Button editButton;
    @FXML private Button addNewBookButton;
    
    
    public void initData(Book book)
    {
        selectedBook = book;
        
        titleTextField.setText(selectedBook.getTitle());
        authorTextField.setText(selectedBook.getAuthorsList());
        genresTextField.setText(selectedBook.getGenresList());
        publisherTextField.setText(selectedBook.getPublisher());
        publishDateDatePicker.setValue(selectedBook.getPublishDate());
        isbnTextField.setText(selectedBook.getIsbn());
        seriesTextField.setText(selectedBook.getSeries());
        coverArtistTextField.setText(selectedBook.getCoverArtist());
        costTextField.setText(selectedBook.getCost() + "");
        numberOfSalesTextField.setText(selectedBook.getSales() + "");
    }
    
    public void initData()
    {
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void addBookButtonPushed()
    {
        String title, author, genre, publisher, isbn, numberInStock, series,
                coverArtist, costString, bookType, numberOfSalesString;
        LocalDate publishDate;
        
        title = titleTextField.getText();
        author = authorTextField.getText();
        genre = genresTextField.getText();
        publisher = publisherTextField.getText();
        isbn = isbnTextField.getText();
        numberInStock = numberInStockTextField.getText();
        series = seriesTextField.getText();
        publishDate = publishDatePicker.getValue();
        coverArtist = coverArtistTextField.getText();
        costString = costTextField.getText();
        numberOfSalesString = numberOfSalesTextField.getText();
        
        Book newBook = new Book(title, isbn, coverArtist, series, publishDate, cost, numberInStock, sales);
        
        outputTextArea.setText("Title: " + title + "\tAuthor: " + author + "\tGenre: "
        + genre + "\nPublisher: " + publisher + "\tISBN: " + isbn + "\tnumberInStock: "
        + numberInStock + "\nSeries: " + series + "\tPublish Date: " + publishDate.toString()
        + "\tCover Arist: " + coverArtist + "\nCost: " + costString + "\tNumber of Sales: " + numberOfSalesString);
       
    }
    
    public double validateCost(String costString)
    {
        double cost = 0.00;
        
        try {
            cost = Double.parseDouble(costString);
        } catch (NumberFormatException e) 
        {
            outputTextArea.appendText("\nThe cost must be a decimal number above zero.");
        }
        
        return cost;
    }
    
     public int validateSales(String salesString)
    {
        int sales = 0;
        
        try {
            sales = Integer.parseInt(salesString);
        } catch (NumberFormatException e) 
        {
            outputTextArea.appendText("\nThe number of sales must be a whole number number equal to or greather than zero.");
        }
        
        return sales;
    }
    
    public void editBookButtonPushed()
    {
        
    }
    
    public void returnButtonPushed()
    {
        
    }
    
}
