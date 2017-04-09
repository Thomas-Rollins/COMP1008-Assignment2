/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOK CONTROLER CLASS
 */
package assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private BookShelf selectedBookShelf;
   
    
    @FXML private Button returnButton;
    @FXML private Button editButton;
    @FXML private Button addNewBookButton;
    
    /**
     * initialize method
     * @param book
     * @param bookShelf 
     */
    public void initData(Book book, BookShelf bookShelf)
    {
        selectedBook = book;
        selectedBookShelf = bookShelf;
        
        titleTextField.setText(selectedBook.getTitle());
        authorTextField.setText(selectedBook.getAuthorsList());
        genresTextField.setText(selectedBook.getListOfGenres());
        publisherTextField.setText(selectedBook.getPublisher());
        try{
            publishDateDatePicker.setValue(selectedBook.getPublishDate());
        } catch (NullPointerException e){}
        
        publisherTextField.setText(selectedBook.getPublisher());
        isbnTextField.setText(selectedBook.getIsbn());
        seriesTextField.setText(selectedBook.getSeries());
        coverArtistTextField.setText(selectedBook.getCoverArtist());
        costTextField.setText(Double.toString(selectedBook.getCost()));
        numberOfSalesTextField.setText(Integer.toString(selectedBook.getSales()));
        numberInStockTextField.setText(Integer.toString(selectedBook.getNumberInStock()));
    }
    
    /**
     * returned initialize method
     * @param bookShelf 
     */
    public void initData(BookShelf bookShelf)
    {
        selectedBookShelf = bookShelf;
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
    
    /**
     * Adds a new book on button press
     * @param event
     * @throws IOException 
     */
    public void addBookButtonPushed(ActionEvent event) throws IOException
    {
        String title, author, genre, publisher, isbn, numberInStockString, series,
                coverArtist, costString, numberOfSalesString;
        LocalDate publishDate;
        
        title = titleTextField.getText();
        author = authorTextField.getText();
        genre = genresTextField.getText();
        publisher = publisherTextField.getText();
        isbn = isbnTextField.getText();
        numberInStockString = numberInStockTextField.getText();
        series = seriesTextField.getText();
        publishDate = publishDatePicker.getValue();
        coverArtist = coverArtistTextField.getText();
        costString = costTextField.getText();
        numberOfSalesString = numberOfSalesTextField.getText();
        
        if(numberInStockString.trim().equals(""))
            numberInStockString = "0";
        if(costString.trim().equals(""))
            costString = "0.00";
        if(numberOfSalesString.trim().equals(""))
            numberOfSalesString = "0";
        
        try {
        Book newBook = new Book(title, author, isbn, coverArtist, series, publisher, 
                publishDate, validateCost(costString), validateNumberInStock(numberInStockString),
                validateSales(numberOfSalesString));
        newBook.addGenres(genre);
        selectedBookShelf.addBook(newBook);
        } catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return;
        }
    
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookShelfView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookshelfViewController controller = loader.getController();
        controller.initData(selectedBookShelf);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
}
    
    /**
     * validates type conversion
     * @param costString
     * @return 
     */
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
    
    /**
     * validates type conversion
     * @param salesString
     * @return 
     */
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
     
     /**
      * validates type conversion
      * @param numberInStockString
      * @return 
      */
     public int validateNumberInStock(String numberInStockString)
    {
        int numberInstock = 0;
        
        try {
            numberInstock = Integer.parseInt(numberInStockString);
        } catch (NumberFormatException e) 
        {
            outputTextArea.appendText("\nThe number in stock must be a whole number number equal to or greather than zero.");
        }
        
        return numberInstock;
    }
     
    /**
     * edits an existing book
     * @param event
     * @throws IOException 
     */
    public void editBookButtonPushed(ActionEvent event) throws IOException
    {   
        String title, author, genre, publisher, isbn, numberInStockString, series,
                coverArtist, costString, numberOfSalesString;
        LocalDate publishDate;
        
        title = titleTextField.getText();
        author = authorTextField.getText();
        genre = genresTextField.getText();
        publisher = publisherTextField.getText();
        isbn = isbnTextField.getText();
        numberInStockString = numberInStockTextField.getText();
        series = seriesTextField.getText();
        publishDate = publishDatePicker.getValue();
        coverArtist = coverArtistTextField.getText();
        costString = costTextField.getText();
        numberOfSalesString = numberOfSalesTextField.getText();
        
        try {
        Book newBook = new Book(title, author, isbn, coverArtist, series, publisher, publishDate, validateCost(costString), validateNumberInStock(numberInStockString), validateSales(numberOfSalesString));
        newBook.addGenres(genre);
        
        selectedBookShelf.addBook(newBook);
        selectedBookShelf.removeBook(selectedBook);
        } catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        //return to bookshelfview
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookShelfView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookshelfViewController controller = loader.getController();
        controller.initData(selectedBookShelf);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    /**
     * returns to BookShelfView
     */
    public void returnButtonPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookShelfView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookshelfViewController controller = loader.getController();
        controller.initData(selectedBookShelf);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
