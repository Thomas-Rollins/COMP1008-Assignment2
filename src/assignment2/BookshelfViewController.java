/**
 * INTRO TO OOP - WINTER 2017
 * ASSIGNMENT TWO
 * BOOKSHELF CONTROLLER CLASS
 */
package assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thomas Rollins
 */
public class BookshelfViewController implements Initializable {

    private BookShelf selectedBookShelf;
    
    @FXML private Label shelfLabel;
    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> genreColumn;
    @FXML private TableColumn<Book, String> authorsColumn;
    @FXML private TableColumn<Book, String> seriesColumn;
    @FXML private TableColumn<Book, LocalDate> publishedColumn;
    @FXML private TableColumn<Book, String> publisherColumn;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, Double> costColumn;
    @FXML private TableColumn<Book, Integer> salesColumn;
    
    @FXML private Button addNewBookButton;
    @FXML private Button returnButton;
    @FXML private Button editBookButton;
    @FXML private Button removeBookButton;
    
    /**
     * initializes the scene data
     * @param bookShelf 
     */
    public void initData(BookShelf bookShelf)
    {
        selectedBookShelf = bookShelf;

        
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("listOfGenres"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("authorsList"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("series"));
        publishedColumn.setCellValueFactory(new PropertyValueFactory<Book, LocalDate> ("publishDate"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("publisher"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("isbn"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Book, Double> ("cost"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer> ("sales"));
        
        
        
        ArrayList<Book> bookList = selectedBookShelf.getAllBooksOnShelf();
        ObservableList<Book> observableBookList = FXCollections.observableArrayList(bookList);
        tableView.setItems(observableBookList);
    }
    
    /**
     * changes the scene to edit a book
     * @param event
     * @throws IOException 
     */
    public void editBookButtonPressed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem(), selectedBookShelf);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /**
     * changes the scene to add a new book
     * @param event
     * @throws IOException 
     */
    public void addBookButtonPressed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookViewController controller = loader.getController();
        controller.initData(selectedBookShelf);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /**
     * returns to the bookstore scene
     * @param event
     * @throws IOException 
     */
    public void returnButtonPressed(ActionEvent event) throws IOException
    {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookStoreView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        BookStoreViewController controller = loader.getController();
        controller.initData(BookStoreViewController.bookStore);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /**
     * deletes a shelf;
     * @param event
     * @throws IOException 
     */
    public void removeBookButtonPressed(ActionEvent event) throws IOException
    {
        ObservableList<Book> selectedBooks, allBooks;
        allBooks = tableView.getItems();
        
        selectedBooks = tableView.getSelectionModel().getSelectedItems();
        
        for (Book book : selectedBooks)
        {
            allBooks.remove(book);
            selectedBookShelf.removeBook(book);
        }
    }
    
    /**
     * enables buttons when a table element is selected
     */
    public void userClickedOnTable()
    {
        this.removeBookButton.setDisable(false);
        this.editBookButton.setDisable(false);
    }
    
    
     /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
}
