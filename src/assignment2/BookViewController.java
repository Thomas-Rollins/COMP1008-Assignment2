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
    @FXML private TextField isbnTextField;
    @FXML private TextField numberInStockTextField;
    @FXML private TextField seriesTextField;
    @FXML private TextField coverArtistTextField;
    @FXML private TextField costTextField;
    @FXML private TextField bookTypeTextField;
    @FXML private TextField numberOfSalesTextField;
    
    @FXML private TextArea outputTextArea;
    
    @FXML private DatePicker publishDatePicker;
    
    @FXML private Button returnButton;
    @FXML private Button editButton;
    @FXML private Button addNewBookButton;
    
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
        bookType = bookTypeTextField.getText();
        numberOfSalesString = numberOfSalesTextField.getText();
        
        outputTextArea.setText("Title: " + title + "\tAuthor: " + author + "\tGenre: "
        + genre + "\nPublisher: " + publisher + "\tISBN: " + isbn + "\tnumberInStock: "
        + numberInStock + "\nSeries: " + series + "\tPublish Date: " + publishDate.toString()
        + "\tCover Arist: " + coverArtist + "\nCost: " + costString + "\tBook Type: "
        + bookType + "\tNumber of Sales: " + numberOfSalesString);
       
        
    }
    
    public void editBookButtonPushed()
    {
        
    }
    
    public void returnButtonPushed()
    {
        
    }
    
}
