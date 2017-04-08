/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, Double> costColumn;
    @FXML private TableColumn<Book, Integer> salesColumn;
    
    @FXML private Button addNewBookButton;
    @FXML private Button returnButton;
    @FXML private Button editBookButton;
    
    
    public void initData(BookShelf bookShelf)
    {
        Book newBook = new Book("Title", "978-92-95055-02-5", "Cover Artist", "Series1",
                LocalDate.of(2007, Month.JANUARY, 2), 19.99, 100, 50);
        newBook.addAuthors(new Author("Valid", "Author", "Canadian", LocalDate.of(1084, Month.MARCH, 12)));
        
        selectedBookShelf = bookShelf;
        selectedBookShelf.addBook(0, newBook);
        
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("listOfGenres"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("authorsList"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("series"));
        publishedColumn.setCellValueFactory(new PropertyValueFactory<Book, LocalDate> ("publishDate"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String> ("isbn"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Book, Double> ("cost"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer> ("sales"));
        
        
        
        ArrayList<Book> bookList = selectedBookShelf.getAllBooksOnShelf();
        ObservableList<Book> observableBookList = FXCollections.observableArrayList(bookList);
        tableView.setItems(observableBookList);
    }
    
    public void editBookButtonPressed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void addBookButtonPressed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        BookViewController controller = loader.getController();
        controller.initData();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
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
    
}
